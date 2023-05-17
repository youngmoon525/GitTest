package Test;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;

public class DAO {
	Scanner sc = new Scanner(System.in);
	DTO dto = new DTO();
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	ResultSet rs1;

	public void menu() {
		String loginSelect;
		while (true) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0번 취소");
			System.out.println("1번 로그인/로그아웃");
			System.out.println("2번 회원가입");
			System.out.println("3번 회원탈퇴");
			System.out.println("4번 회원정보보기 및 수정");
			System.out.println("5번 게시판");
			System.out.println("6번 날씨보기");
			String select = sc.nextLine();
			if (select.equals("1")) {
//				로그인 상태시 로그아웃메소드로, 로그아웃 상태시 로그인 메소드로 이동하게
				if (dto.getState().equals("off")) {
//					로그아웃 상태이니 로그인창(메소드 만들어서 setState(on)) 유도 or 이전화면
					while (true) {
						System.out.println("로그아웃 상태입니다. 로그인하시려면 1번 취소하시려면 0번을 입력해주세요.");
						loginSelect = sc.nextLine();
						if (loginSelect.equals("1")) {
							login();
							break;
						} else if (loginSelect.equals("0")) {
							System.out.println("취소합니다.");
							break;
						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						}
					}
				}
				if (dto.getState().equals("on")) {
					logout();
				}
			} else if (select.equals("2")) {
				createAccount();
				break;
			} else if (select.equals("3")) {
				deleteAccount();
				break;
			} else if (select.equals("4")) {
				Account();
			} else if (select.equals("5")) {
				if (dto.getState().equals("off")) {
					while (true) {
						System.out.println("로그아웃 상태입니다. 로그인하시려면 1번 취소하시려면 0번을 입력해주세요.");
						loginSelect = sc.nextLine();
						if (loginSelect.equals("1")) {
							login();
							break;
						} else if (loginSelect.equals("0")) {
							System.out.println("취소합니다.");
							break;
						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						}
					}
				} else if (dto.getState().equals("on")) {
					board();
				}

			} else if (select.equals("6")) {
				weather();
			} else if (select.equals("0")) {
				System.out.println("취소합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void createAccount() {
		System.out.println("회원가입을 선택하셨습니다.");
		System.out.println("아이디 :\n비밀번호 :\n이름 :\n전화번호 :\n나이 :");
		String createSelect;
		while (true) {
			System.out.println("아이디(10글자이내)를 입력해주세요.");
			String id = sc.nextLine();
			boolean isDuplicated = checkDuplicatedId(id);
			if (isDuplicated) {
				System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요.");
				continue;
			} else {
				dto.setId(id);
			}
			while (true) {
				System.out.println("입력하신 아이디가" + id + "가 맞으시면 1번 다시 입력하시려면 0번을입력해주세요.");
				createSelect = sc.nextLine();
				if (createSelect.equals("1")) {
					dto.setId(id);
					break;
				} else if (createSelect.equals("0")) {
					break;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
			}
			if (createSelect.equals("1")) {
				break;
			}
		}
		dto.setPw(showMsgRtnStr("비밀번호(10글자이내)를 입력해주세요."));
		dto.setName(showMsgRtnStr("이름(5글자이내)을 입력해주세요."));
		dto.setCall(showMsgRtnStr("전화번호를 입력해주세요."));
		while (true) {
			try {
				System.out.println("나이를 입력해주세요.");
				int age = Integer.parseInt(sc.nextLine());
				while (true) {
					System.out.println("입력하신 나이가" + age + "가 맞으시면 1번 다시 입력하시려면 0번을입력해주세요.");
					createSelect = sc.nextLine();
					if (createSelect.equals("1")) {
						dto.setAge(age);
						break;
					} else if (createSelect.equals("0")) {
						break;
					} else {
						System.out.println("잘못입력하셨습니다.");
					}
				}
				if (createSelect.equals("1")) {
					break;
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}

		}
		System.out.println("아이디 : " + dto.getId());
		System.out.println("비밀번호 : " + dto.getPw());
		System.out.println("이름 : " + dto.getName());
		System.out.println("전화번호 : " + dto.getCall());
		System.out.println("나이 : " + dto.getAge());
		System.out.println("회원가입이 완료되었습니다.");
		try {
			conn = getConn();
			ps = conn.prepareStatement(
					"INSERT INTO MEMBER (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_CALL, MEMBER_AGE) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getCall());
			ps.setInt(5, dto.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		menu();
	}

	private boolean checkDuplicatedId(String id) {
		boolean result = false;
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}

	public void deleteAccount() {
		String id, pw;
		String deleteSelect;
		String deleteId;
		String deletePw = null;
		System.out.println("회원 탈퇴를 선택하셨습니다.");
		while (true) {
			System.out.println("1번을 누르면 회원탈퇴를 진행합니다.");
			System.out.println("0번을 누르면 탈퇴를 취소하고 이전화면으로 이동합니다.");
			deleteSelect = sc.nextLine();
			if (deleteSelect.equals("1")) {
				while (true) {
					System.out.println("아이디를 입력해주세요.");
					id = sc.nextLine();
					while (true) {
						System.out.println("입력하신 아이디가 " + id + "가 맞으시면 1번을, 다시 입력하시려면 2번을, 이전화면으로 이동하시려면 0번을 입력해주세요.");
						deleteId = sc.nextLine();
						if (deleteId.equals("1")) {
							while (true) {
								System.out.println("비밀번호를 입력해주세요.");
								pw = sc.nextLine();
								while (true) {
									System.out.println(
											"입력하신 비밀번호가 : " + pw + " 가 맞으시면 1번을, 다시입력하시려면 2번을, 취소하시려면 0번을 입력해주세요.");
									deletePw = sc.nextLine();
									if (deletePw.equals("1")) {
										try {
											conn = getConn();
											ps = conn.prepareStatement(
													"DELETE FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?");
											ps.setString(1, id);
											ps.setString(2, pw);
											int result = ps.executeUpdate();
											if (result >= 1) {
												System.out.println("회원탈퇴 되었습니다.");
												break;
											} else {
												System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
												break;
											}
										} catch (SQLException e) {
											System.out.println("오류");
											e.printStackTrace();
										} finally {
											dbClose();
										}

									} else if (deletePw.equals("2")) {
										break;
									} else if (deletePw.equals("0")) {
										break;
									} else {
										System.out.println("잘못 입력하셨습니다.");
									}
									break;
								}
								if (deletePw.equals("0")) {
									break;
								}
								break;
							}
						} else if (deleteId.equals("2")) {
							break;
						} else if (deleteId.equals("0")) {
							System.out.println("이전화면으로 이동합니다.");
							break;
						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						}
						if (deletePw.equals("0")) {
							break;
						}
						break;
					}
					if (deleteId.equals("1") || deleteId.equals("0")) {
						break;
					}
					break;
				}
			} else if (deleteSelect.equals("0")) {
				System.out.println("회원탈퇴를 취소합니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}
		menu();
	}

	public void login() {
		String id, pw;
		String loginId;
		String loginPw = null;
		String loginSelect;
		while (true) {
			System.out.println("1번을 누르면 로그인를 진행합니다.");
			System.out.println("0번을 누르면 로그인을 취소하고 이전화면으로 이동합니다.");
			loginSelect = sc.nextLine();
			if (loginSelect.equals("1")) {
				while (true) {
					System.out.println("아이디를 입력해주세요.");
					id = sc.nextLine();
					while (true) {
						System.out.println("입력하신 아이디가 " + id + " 가 맞으시면 1번을, 다시 입력하시려면 2번을, 이전화면으로 이동하시려면 0번을 입력해주세요.");
						loginId = sc.nextLine();
						if (loginId.equals("1")) {
							while (true) {
								System.out.println("비밀번호를 입력해주세요.");
								pw = sc.nextLine();
								while (true) {
									System.out.println(
											"입력하신 비밀번호가 : " + pw + " 가 맞으시면 1번을, 다시입력하시려면 2번을, 취소하시려면 0번을 입력해주세요.");
									loginPw = sc.nextLine();
									if (loginPw.equals("1")) {
										try {
											conn = getConn();
											ps = conn.prepareStatement(
													"SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ? ");
											ps.setString(1, id);
											ps.setString(2, pw);
											rs = ps.executeQuery();
											if (rs.next()) {
												System.out.println("로그인 되었습니다.");
												dto.setState("on");
												dto.setId(id);
												break;
											} else {
												System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
												break;
											}
										} catch (SQLException e) {
											System.out.println("오류");
											e.printStackTrace();
										} finally {
											dbClose();
										}
									} else if (loginPw.equals("2")) {
										break;
									} else if (loginPw.equals("0")) {
										break;
									} else {
										System.out.println("잘못 입력하셨습니다.");
										continue;
									}
								}
								if (loginPw.equals("0") || loginPw.equals("1")) {
									break;
								}
							}
						} else if (loginId.equals("2")) {
							break;
						} else if (loginId.equals("0")) {
							System.out.println("이전화면으로 이동합니다.");
							break;
						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
							continue;
						}
						if (loginPw.equals("0")) {
							break;
						}
						break;
					}
					if (loginId.equals("1") || loginId.equals("0")) {
						break;
					}
				}
			} else if (loginSelect.equals("0")) {
				System.out.println("로그인을 취소합니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				continue;
			}
			break;
		}
	}

	public void logout() {
		String logoutSelect;
		while (true) {
			System.out.println("로그아웃 하시려면 1번을 취소하시려면 0번을 입력해주세요.");
			logoutSelect = sc.nextLine();
			if (logoutSelect.equals("1")) {
				dto.setState("off");
				System.out.println("로그아웃 되었습니다.");
				dto.setId(null);
				dto.setPw(null);
				break;
			} else if (logoutSelect.equals("0")) {
				System.out.println("취소하셨습니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}
	}

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		}
		return conn;
	}

	public void dbClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String showMsgRtnStr(String msg) {
		String createSelect = null;
		String rtnTemp = null;
		while (true) {
			System.out.println(msg);
			rtnTemp = sc.nextLine();
			while (true) {
				System.out.println("입력하신 값 " + rtnTemp + " (이)가 맞으시면 1번 다시 입력하시려면 0번을입력해주세요.");
				createSelect = sc.nextLine();
				if (createSelect.equals("1")) {
					break;
				} else if (createSelect.equals("0")) {
					break;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
			}
			if (createSelect.equals("1")) {
				break;
			}
		}
		return rtnTemp;
	}

	public void Account() {
		String id, pw, select, updateSelect, updatePw, updateName, updateCall, updateAge;
		String updateSelect2;
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?");
			System.out.println("조회하실 id를 입력해주세요.");
			id = sc.nextLine();
			ps.setString(1, id);
			System.out.println("조회하실 pw를 입력해주세요.");
			pw = sc.nextLine();
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (true) {
				if (rs.next()) {
					System.out.println("MEMBER_ID : " + rs.getString("MEMBER_ID"));
					System.out.println("MEMBER_PW : " + rs.getString("MEMBER_PW"));
					System.out.println("MEMBER_NAME : " + rs.getString("MEMBER_NAME"));
					System.out.println("MEMBER_CALL : " + rs.getString("MEMBER_CALL"));
					System.out.println("MEMBER_AGE : " + rs.getInt("MEMBER_AGE"));

					System.out.println("회원정보 수정을 원하시면 1번을 취소하시려면 0번을 입력해주세요.");
					select = sc.nextLine();
					if (select.equals("1")) {
						while (true) {
							ps = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
							ps.setString(1, id);
							rs = ps.executeQuery();
							rs.next();
							System.out.println("수정하실 부분을 선택해주세요.");
							System.out.println("MEMBER_ID : " + rs.getString("MEMBER_ID"));
							System.out.println("1번 MEMBER_PW : " + rs.getString("MEMBER_PW"));
							System.out.println("2번 MEMBER_NAME : " + rs.getString("MEMBER_NAME"));
							System.out.println("3번 MEMBER_CALL : " + rs.getString("MEMBER_CALL"));
							System.out.println("4번 MEMBER_AGE : " + rs.getInt("MEMBER_AGE"));
							System.out.println("0번 취소");
							updateSelect = sc.nextLine();
							if (updateSelect.equals("1")) {
								System.out.println("비밀번호 수정을 선택하셨습니다.");
								while (true) {
									System.out.println("수정하실 비밀번호를 입력해주세요.");
									updatePw = sc.nextLine();
									System.out.println(
											"수정하실 비밀번호가 " + updatePw + " 맞으시면 1번을 다시 입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
									updateSelect2 = sc.nextLine();
									if (updateSelect2.equals("1")) {
										ps = conn.prepareStatement(
												"UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ?");
										ps.setString(1, updatePw);
										ps.setString(2, id);
										int result = ps.executeUpdate();
										if (result >= 1) {
											System.out.println("비밀번호 : " + updatePw + " 로 변경되었습니다.");
											break;
										}
									} else if (updateSelect2.equals("2")) {
										continue;
									} else if (updateSelect2.equals("0")) {
										System.out.println("취소하셨습니다.");
										break;
									} else {
										System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
									}
								}

							} else if (updateSelect.equals("2")) {
								System.out.println("이름 수정을 선택하셨습니다.");
								while (true) {
									System.out.println("수정하실 이름을 입력해주세요.");
									updateName = sc.nextLine();
									System.out.println(
											"수정하실 이름이 " + updateName + " 맞으시면 1번을 다시 입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
									updateSelect2 = sc.nextLine();
									if (updateSelect2.equals("1")) {
										ps = conn.prepareStatement(
												"UPDATE MEMBER SET MEMBER_NAME = ? WHERE MEMBER_ID = ?");
										ps.setString(1, updateName);
										ps.setString(2, id);
										int result = ps.executeUpdate();
										if (result >= 1) {
											System.out.println("이름 : " + updateName + " 로 변경되었습니다.");
											break;
										}
									} else if (updateSelect2.equals("2")) {
										continue;
									} else if (updateSelect2.equals("0")) {
										System.out.println("취소하셨습니다.");
										break;
									} else {
										System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
									}
								}
							} else if (updateSelect.equals("3")) {
								System.out.println("번호 수정을 선택하셨습니다.");
								while (true) {
									System.out.println("수정하실 번호를 입력해주세요.");
									updateCall = sc.nextLine();
									System.out.println(
											"수정하실 번호가 " + updateCall + " 맞으시면 1번을 다시 입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
									updateSelect2 = sc.nextLine();
									if (updateSelect2.equals("1")) {
										ps = conn.prepareStatement(
												"UPDATE MEMBER SET MEMBER_CALL = ? WHERE MEMBER_ID = ?");
										ps.setString(1, updateCall);
										ps.setString(2, id);
										int result = ps.executeUpdate();
										if (result >= 1) {
											System.out.println("번호 : " + updateCall + " 로 변경되었습니다.");
											break;
										}
									} else if (updateSelect2.equals("2")) {
										continue;
									} else if (updateSelect2.equals("0")) {
										System.out.println("취소하셨습니다.");
										break;
									} else {
										System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
									}
								}
							} else if (updateSelect.equals("4")) {
								System.out.println("나이 수정을 선택하셨습니다.");
								while (true) {
									System.out.println("수정하실 나이를 입력해주세요.");
									updateAge = sc.nextLine();
									System.out.println(
											"수정하실 나이가 " + updateAge + " 맞으시면 1번을 다시 입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
									updateSelect2 = sc.nextLine();
									if (updateSelect2.equals("1")) {
										ps = conn.prepareStatement(
												"UPDATE MEMBER SET MEMBER_AGE = ? WHERE MEMBER_ID = ?");
										ps.setString(1, updateAge);
										ps.setString(2, id);
										int result = ps.executeUpdate();
										if (result >= 1) {
											System.out.println("나이 : " + updateAge + " 로 변경되었습니다.");
											break;
										}
									} else if (updateSelect2.equals("2")) {
										continue;
									} else if (updateSelect2.equals("0")) {
										System.out.println("취소하셨습니다.");
										break;
									} else {
										System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
									}
								}
							} else if (updateSelect.equals("0")) {
								System.out.println("취소합니다.");
								break;
							} else {
								System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
							}
						}
					} else if (select.equals("0")) {
						System.out.println("취소합니다");
						break;
					} else {
						System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						continue;
					}
				} else {
					System.out.println("아이디나 비밀번호가 틀렸습니다.");
					break;
				}
				break;
			}
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public void board() {
		String viewSelect;
		System.out.println("게시판에 접속하셨습니다.");
		try {

			while (true) {
//					System.out.println("글번호\t글제목");  글 리스트 보여주는 
//					System.out.print("  " + rs.getString("TEXT_NUMBER") + "\t");
//					System.out.println(rs.getString("TITLE"));
				System.out.println("글읽기 : 1");
				System.out.println("글쓰기 : 2");
				System.out.println("글수정 : 3");
				System.out.println("글삭제 : 4");
				System.out.println("취소 : 0");
				viewSelect = sc.nextLine();
				if (viewSelect.equals("2")) {
					boardWrite();
				} else if (viewSelect.equals("1")) {
					readBoard();
				} else if (viewSelect.equals("3")) {
					updateBoard();
				} else if (viewSelect.equals("4")) {
					deleteBoard();
				} else if (viewSelect.equals("0")) {
					System.out.println("취소하셨습니다.");
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
					continue;
				}
			}

		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public void boardWrite() {
		String writeSelect, writeTitle, writeContent, titleSelect, contentSelect;
		System.out.println("글쓰기에 접속하셨습니다. ");
		while (true) {
			System.out.println("글을 쓰시려면 1번을 취소하시려면 0번을 입력해주세요.");
			writeSelect = sc.nextLine();
			if (writeSelect.equals("1")) {
				while (true) {
					System.out.println("작성하실 글의 제목을 입력해주세요.");
					writeTitle = sc.nextLine();
					System.out
							.println("작성하실 글의 제목이 : " + writeTitle + " 이(가) 맞으시면 1번을 다시입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
					titleSelect = sc.nextLine();
					if (titleSelect.equals("1")) {
						while (true) {
							System.out.println("작성하실 글의 내용을 입력해주세요");
							writeContent = sc.nextLine();
							System.out.println("글의 내용이 입력되었습니다.");
							System.out.println("글을 올리시려면 1번을 글의 내용을 다시입력하시려면 2번을 취소하시려면 0번을 입력해주세요.");
							contentSelect = sc.nextLine();
							if (contentSelect.equals("1")) {
								try {
									conn = getConn();
									ps = conn.prepareStatement(
											"INSERT INTO BOARD2 (TEXT_NUMBER, TITLE, CONTENTS, MEMBER_ID, WRITE_DATE) VALUES ((SELECT MAX(TEXT_NUMBER)+1 FROM BOARD2), ?, ?, ?, sysdate)");
									ps.setString(1, writeTitle);
									ps.setString(2, writeContent);
									ps.setString(3, dto.getId());
									ps.executeUpdate();
								} catch (SQLException e) {
									System.out.println("오류");
									e.printStackTrace();
								} finally {
									dbClose();
								}
								System.out.println("글이 작성되었습니다.");
								break;
							} else if (contentSelect.equals("2")) {
								continue;
							} else if (contentSelect.equals("0")) {
								break;
							} else {
								System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
								continue;
							}

						}
					} else if (titleSelect.equals("2")) {
						continue;
					} else if (titleSelect.equals("0")) {
						System.out.println("취소하셨습니다.");
						break;
					} else {
						System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						continue;
					}
					break;
				}

			} else if (writeSelect.equals("0")) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}
	}

	public void readBoard() {
		int readSelect;
		System.out.println("글읽기에 접속하셨습니다.");
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT * FROM BOARD2 ORDER BY 1");
			rs = ps.executeQuery();
			System.out.println("글번호\t\t\t글제목\t\t\t작성자");
			while (rs.next()) {
				System.out.print("  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
				System.out.println(rs.getString("MEMBER_ID"));
			}
			System.out.println("읽으실 글의 번호를 입력해주세요.");
//			int minTextNum = rs.getInt("SELECT MIN(TEXT_NUMBER)+1 FROM BOARD2");
//			int maxTextNum = rs.getInt("SELECT MAX(TEXT_NUMBER)+1 FROM BOARD2");
			System.out.println("취소 : 0번");
			while (true) {
				ps = conn.prepareStatement("SELECT MAX(TEXT_NUMBER) FROM BOARD2");
				rs = ps.executeQuery();
				rs.next();
				try {
					while (true) {
						readSelect = Integer.parseInt(sc.nextLine());
						if (readSelect == 0) {
							System.out.println("취소합니다.");
							break;
						} else {
							ps = conn.prepareStatement("SELECT * FROM BOARD2 WHERE TEXT_NUMBER = ?");
							ps.setInt(1, readSelect);
							rs = ps.executeQuery();
							if (rs.next()) {
								System.out.println("글번호\t글제목\t작성자");
								System.out.print(
										"  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
								System.out.println(rs.getString("MEMBER_ID"));
								System.out.println("글내용 : " + rs.getString("CONTENTS"));
								break;
							} else {
								System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
								continue;
							}
						}
					}
				} catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBoard() {
		int updateSelect;
		String updateSelect2, updateTitle, updateContent;
		System.out.println("글수정에 접속하셨습니다.");
		try {
			while (true) {
				conn = getConn();
				ps = conn.prepareStatement("SELECT * FROM BOARD2 ORDER BY 1");
				rs = ps.executeQuery();

				System.out.println("수정하실 글의 번호를 입력해주세요.");
				System.out.println("취소 : 0번");
				System.out.println("글번호\t\t\t글제목\t\t\t작성자");
				while (rs.next()) {
					System.out.print("  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
					System.out.println(rs.getString("MEMBER_ID"));
				}
				updateSelect = Integer.parseInt(sc.nextLine());
				try {
					if (updateSelect == 0) {
						System.out.println("취소합니다.");
						break;
					} else {
						ps = conn.prepareStatement("SELECT * FROM BOARD2 WHERE TEXT_NUMBER = ?");
						ps.setInt(1, updateSelect);
						rs = ps.executeQuery();
						if (rs.next()) {
							System.out.println("글번호\t글제목\t작성자");
							System.out.print(
									"  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
							System.out.println(rs.getString("MEMBER_ID"));
							System.out.println("글내용 : " + rs.getString("CONTENTS"));
							while (true) {
								System.out.println("수정하실곳을 선택해주세요.");
								System.out.println("1번 : 글제목");
								System.out.println("2번 : 글내용");
								System.out.println("0번 : 취소");
								updateSelect2 = sc.nextLine();
								if (updateSelect2.equals("1")) {
									System.out.println("글제목 수정을 선택하셨습니다.");
									System.out.println("수정하실 글 제목을 입력해주세요.");
									updateTitle = sc.nextLine();
									ps = conn.prepareStatement("UPDATE BOARD2 SET TITLE = ? WHERE TEXT_NUMBER = ?");
									ps.setString(1, updateTitle);
									ps.setInt(2, updateSelect);
									ps.executeUpdate();
									System.out.println("글제목이 수정되었습니다.");
									continue;
								} else if (updateSelect2.equals("2")) {
									System.out.println("글내용 수정을 선택하셨습니다.");
									System.out.println("수정하실 글 내용을 입력해주세요.");
									updateContent = sc.nextLine();
									ps = conn.prepareStatement("UPDATE BOARD2 SET TITLE = ? WHERE TEXT_NUMBER = ?");
									ps.setString(1, updateContent);
									ps.setInt(2, updateSelect);
									ps.executeUpdate();
									System.out.println("글내용이 수정되었습니다.");
									continue;
								} else if (updateSelect2.equals("0")) {
									System.out.println("취소합니다.");
									break;
								} else {
									System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
									continue;
								}
							}
						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
							continue;
						}
					}
				} catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard() {
		int deleteSelect;
		String deleteSelect2, deleteTitle, deleteContent;
		System.out.println("글삭제에 접속하셨습니다.");
		try {
			while (true) {
				conn = getConn();
				ps = conn.prepareStatement("SELECT * FROM BOARD2 ORDER BY 1");
				rs = ps.executeQuery();

				System.out.println("삭제하실 글의 번호를 입력해주세요.");
				System.out.println("취소 : 0번");
				System.out.println("글번호\t\t\t글제목\t\t\t작성자");
				while (rs.next()) {
					System.out.print("  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
					System.out.println(rs.getString("MEMBER_ID"));
				}
				deleteSelect = Integer.parseInt(sc.nextLine());
				try {
					if (deleteSelect == 0) {
						System.out.println("취소합니다.");
						break;
					} else {
						ps = conn.prepareStatement("SELECT * FROM BOARD2 WHERE TEXT_NUMBER = ?");
						ps.setInt(1, deleteSelect);
						rs = ps.executeQuery();
						if (rs.next()) {
							System.out.println("글번호\t글제목\t작성자");
							System.out.print(
									"  " + rs.getInt("TEXT_NUMBER") + "\t\t\t" + rs.getString("TITLE") + "\t\t\t");
							System.out.println(rs.getString("MEMBER_ID"));
							System.out.println("글내용 : " + rs.getString("CONTENTS"));
							if (rs.getString("member_id").equals(dto.getId())) {
								ps = conn
										.prepareStatement("DELETE FROM BOARD2 WHERE TEXT_NUMBER = ? AND MEMBER_ID = ?");
								ps.setInt(1, deleteSelect);
								ps.setString(2, dto.getId());
								ps.executeUpdate();
								System.out.println("삭제되었습니다.");
							} else {
								System.out.println("게시한 글의 아이디가 달라 삭제가 불가능합니다.");
							}

						} else {
							System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
							continue;
						}
					}
				} catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void weather() {
		String[][] tempCategory = { { "T1H", "기온" }, { "RN1", "1시간 내 강수량" }, { "REH", "습도" }, { "PTY", "강수형태" },
				{ "VEC", "풍향" }, { "WSD", "풍속" } };

		String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?";
		String doc = null;
		String cty; // category
		// T1H(기온 ℃), RN1(1시간 강수량 mm), REH(습도 %), PTY(강수형태), VEC(풍향 deg), WSD(풍속 m/s)
		// 강수형태 수치에 대해서 -> 의미없음(0), 비(1), 비/눈(2), 눈(3), 소나기(4), 빗방울(5), 빗방울/눈날림(6),
		// 눈날림(7)

		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String today = sdformat.format(cal.getTime()); // 날짜

		cal.add(Calendar.HOUR, -1); // 현 시간부터 1시간 전
		SimpleDateFormat sdtime = new SimpleDateFormat("HH" + "00");
		String hour = sdtime.format(cal.getTime());

		SimpleDateFormat sddate = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 바꾸기
		cal.setTime(date);
		String formatdate = sddate.format(cal.getTime());

		cal.add(Calendar.HOUR, -1);
		SimpleDateFormat sdhour = new SimpleDateFormat("HH시"); // 시간 형식 바꾸기
		String formathour = sdhour.format(cal.getTime());

		try {
			doc = Jsoup.connect(url).data("pageNo", "1").data("numOfRows", "10").data("dataType", "Json")
					.data("base_date", today).data("base_time", hour).data("nx", "58").data("ny", "74")
					.data("serviceKey",
							"kmc0ZV1P4EDjawY1Lf6lvCWeZXhgexI8O3A59ZNccISKWGOaO4IIUn+TAO8dYHAhjcPOkkGwsioB7rC1UgPOCQ==")
					.timeout(1000 * 40).userAgent("chrome").ignoreContentType(true).execute().body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser(); // 문자열 -> JsonObject 형태로 바꿔줌
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(doc);
			jsonObj = (JSONObject) jsonObj.get("response");
			jsonObj = (JSONObject) jsonObj.get("body");
			jsonObj = (JSONObject) jsonObj.get("items");
			JSONArray array = (JSONArray) jsonObj.get("item");
			System.out.println("날짜:" + formatdate + " | " + "예보시간:" + formathour + " | 위치:광주광역시");
			System.out.println("========================================");
			for (int i = 0; i < array.size(); i++) {
				JSONObject tempObj = (JSONObject) array.get(i);
				// System.out.println("카테고리 obj"+tempObj.get("category"));
				for (int j = 0; j < tempCategory.length; j++) {
					// System.out.println("배열"+tempCategory[j][0]);
					if (tempObj.get("category").equals(tempCategory[j][0])) {
						System.out.println(tempCategory[j][1] + ": " + tempObj.get("obsrValue"));

					}
				}

			}
		} catch (Exception e) {
			// String json이 key와 value를 가진 데이터가 아닌 그냥 일반 문자열이라면 오류가 발생.
			e.printStackTrace();
		}
	}
}
