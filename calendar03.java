
//최종 코드
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class calendar03 {

	public static void main(String[] args) {
		JFrame f = new JFrame("calendar");

		JLabel l1 = new JLabel("시작년도(ex:2020)");
		JTextField tf1 = new JTextField();
		JLabel l2 = new JLabel("시작 월(ex:05)");
		JTextField tf2 = new JTextField();
		JLabel l3 = new JLabel("시작 일(ex:31)");
		JTextField tf3 = new JTextField();
		JLabel l4 = new JLabel("디데이 일 수(ex:200)");
		JTextField tf4 = new JTextField();
		JLabel result = new JLabel();

		l1.setBounds(50, 100, 300, 30);// l1라벨 옆으로50, 아래로100에 위치
		l2.setBounds(50, 140, 300, 30);// l2라벨 가로300, 세로30 크기
		l3.setBounds(50, 180, 300, 30);
		l4.setBounds(50, 220, 300, 30);

		tf1.setBounds(200, 100, 200, 30);
		tf2.setBounds(200, 140, 200, 30);
		tf3.setBounds(200, 180, 200, 30);
		tf4.setBounds(200, 220, 200, 30);

		result.setBounds(200, 260, 300, 30);

		JButton b = new JButton("디데이 계산");
		b.setBounds(150, 340, 200, 30);
		
		l1.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		l2.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		l3.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		l4.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		
		tf1.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		tf2.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		tf3.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		tf4.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		
		result.setFont(new Font ("맑은 고딕",Font.BOLD,15));
		b.setFont(new Font ("맑은 고딕",Font.BOLD,15));

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int year, mon, day;// 시작 날짜
				int D;// 디데이 일 수
				int d = 0;// 계산할 디데이 일 수 , 남은 디데이 일 수
				int x, i;// 반복문 종료횟수 지정 변수,반복문의 인수,
				int Nyear;// 윤년계산을 위해 년도를 잠시 복사할 변수
				int Q;// 디데이계산 복사

				year = Integer.parseInt(tf1.getText());
				mon = Integer.parseInt(tf2.getText());
				day = Integer.parseInt(tf3.getText());
				D = Integer.parseInt(tf4.getText());

				D365: {
					if (D < 365) {
					
						if (mon == 2) {// 입력 월이 2월일 때
							if ( year % 400 == 0||year%100!=0&&year % 4 == 0 ) {// 윤년조건
								x = D - (29 - day);// 남은 일수 계산
								if (x <= 0) {// 남은 일 수가 음수일 때
									if ((D + day) <= 29) {
										result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
										break D365;
									}
								} else {
									mon++;
									d = x;
								}
									
							} else {// 윤년이 아닐 때
								x = D - (28 - day);
								if (x <= 0) {
									if ((D + day) <= 28) {
										result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
										break D365;
									}
								} else
								{
									mon++;
									d = x;
								}
							}
						}

						else if ((mon == 4) || (mon == 6) || (mon == 9) || (mon == 11)) {
							x = D - (30 - day);
							if (x <= 0) {
								if ((D + day) <= 30) {
									result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}
						} else {
							x = D - (31 - day);
							if (x <= 0) {
								if ((D + day) <= 31) {
									result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}

						}

						i = mon;
						Nyear = year;// 윤년계산을 위해 년도값을 복사함

						Dd: {
							for (;;) {
								if (i % 12 == 2) {
									if (i > 12)
										Nyear++;
									if (Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {
										if (d > 29) {
											d = d - 29;
											i++;
											continue;
										} else
											break Dd;
									} else {
										if (d > 28) {
											d = d - 28;
											i++;
											continue;
										} else
											break Dd;
									}
								} else if (i % 12 == 4 || i % 12 == 6 || i % 12 == 9 || i % 12 == 11) {
									if (d > 30) {
										d = d - 30;
										i++;
										continue;
									} else
										break Dd;
								} else {
									if (d > 31) {
										d = d - 31;
										i++;
										continue;
									} else
										break Dd;
								}
							}
						}
						;

						if (i > 12)
							year++;

						if (i % 12 == 0)
							mon = 12;

						else
							mon = i % 12;
						result.setText("" + year + "년" + mon + "월" + d + "일");
					}

					if (D == 365) {
						if ( year % 400 == 0||year%100!=0&&year % 4 == 0) {
							if (mon == 1 || mon == 2) {// 윤년 1월 또는 2월일 때
								if (mon == 1 && day == 1) { // 윤년 1월1일일 때
									mon = 12;
									day = 31;
									result.setText("" + year + "년" + mon + "월" + day + "일");
									break D365;
								} else {
									year = year + 1;
									day = day - 1;
									result.setText("" + year + "년" + mon + "월" + day + "일");
									break D365;
								}
							} else {
								year = year + 1;
								result.setText("" + year + "년" + mon + "월" + day + "일");
							}

						}

						else {
							year = year + 1;
							if ( year % 400 == 0||year%100!=0&&year % 4 == 0) {
								if (mon <= 2)
									result.setText("" + year + "년" + mon + "월" + day + "일");
								else if (mon == 3 && day == 1) {
									mon--;
									day = 29;
								} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
									if (day == 1) {
										mon--;
										day = 31;
									} else
										day--;
								} else {
									if (day == 1) {
										mon--;
										day = 30;
									} else
										day--;
								}
								result.setText("" + year + "년" + mon + "월" + day + "일");
							} else
								result.setText("" + year + "년" + mon + "월" + day + "일");

							break D365;
						}
					}

					else if (D > 365) {
						Nyear = year;
						Q = 0;
						if (mon > 2) {// 2월 이후일 때
							First: {
								while (true) {// 무한루프
									if ( Nyear % 4 != 0||Nyear%100==0&&Nyear % 400 != 0) {// 해당 년도가 윤년이 아닐경우
										if ((Nyear + 1) % 4 != 0 ||(Nyear+1)%100==0&& (Nyear + 1) % 400 != 0) {// 다음 년도가 윤년이 아니면
											if (D >= Q && (Q + 365) <= D) {//디데이가 계산값보다 큰 경우
												Q = Q + 365;
												Nyear++;
											} else {
												Nyear++;
												year = Nyear;
												D = D - Q;
												break First;
											}
										} else {// 다음년도가 윤년이면
											if (D >= Q && (Q + 366) <= D) {
												Q = Q + 366;
												Nyear++;
											} else {
												Nyear++;
												year = Nyear;
												D = D - Q;
												break First;
											}
										}
									}

									else {// 해당 년도가 윤년이면
										if (D >= Q&&(Q+365)<=D) {
												Q = Q + 365;
												Nyear++;
										} else {
											Nyear++;
											year = Nyear;
											D = D - Q;
											break First;
										}
									}
								}
							}
							;

						} else {// 2월 이전일 때
							Secon: {
								while (true) {
									if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {// 해당년도가 윤년인 경우
										if (D >= Q&&(Q+366)<=D) {
										
												Q = Q + 366;
												Nyear++;
											
										} else {
											Nyear++;
											year = Nyear;
											D = D - Q;
											break Secon;
										}

									} else {// 윤년이 아닐 경우
										if (D >= Q&&(Q+365)<=D) {
												Q = Q + 365;
												Nyear++;
										} else {
											Nyear++;
											year = Nyear;
											D = D - Q;
											break Secon;
										}

									}
								}
							}
							;
						}
						i=mon;
						d=D;
						DD: {//이후 코드에 윤년조건 계산을 위한 정확한 년도 계산 용도
							for (;;) {
								if (i % 12 == 2) {
									if (i < 12)
										Nyear--;//해를 넘기지 않을 경우 원래 값보다 1만큼 작아야 함
									if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {
										if (d > 29) {
											d = d - 29;
											i++;
											continue;
										} else
											break DD;
									} else {
										if (d > 28) {
											d = d - 28;
											i++;
											continue;
										} else
											break DD;
									}
								} else if (i % 12 == 4 || i % 12 == 6 || i % 12 == 9 || i % 12 == 11) {
									if (d > 30) {
										d = d - 30;
										i++;
										continue;
									} else
										break DD;
								} else {
									if (d > 31) {
										d = d - 31;
										i++;
										continue;
									} else
										break DD;
								}
							}
						};
						

			
						
						if (mon == 2) {// 입력 월이 2월일 때
							if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {// 윤년조건
								x = D - (29 - day);// 남은 일수 계산
								if (x <= 0) {// 남은 일 수가 음수이거나 0일 때
									if ((D + day) <= 29) {
										year--;//해를 안넘겼으므로 계산된 년도에서 1을 뺌
										result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
										break D365;
									}
								} else
								{
									mon++;
									d = x;
								}
							} else {// 윤년이 아닐 때
								x = D - (28 - day);
								if (x <= 0) {
									if ((D + day) <= 28) {
										year--;
										result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
										break D365;
									}
								} else
								{
									mon++;
									d = x;
								}
							}
						}

						else if ((mon == 4) || (mon == 6) || (mon == 9) || (mon == 11)) {
							x = D - (30 - day);
							if (x <= 0) {
								if ((D + day) <= 30) {
									year--;
									result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}
						} else {
							x = D - (31 - day);
							if (x <= 0) {
								if ((D + day) <= 31) {
									year--;
									result.setText("" + year + "년" + mon + "월" + (D + day) + "일");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}

						}

						i = mon;
						Nyear = year;// 윤년계산을 위해 년도값을 복사함

						Dd: {
							for (;;) {
								if (i % 12 == 2) {
									if (i < 12)
										Nyear--;//해를 넘기지 않을 경우 원래 값보다 1만큼 작아야 함
									if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {
										if (d > 29) {
											d = d - 29;
											i++;
											continue;
										} else
											break Dd;
									} else {
										if (d > 28) {
											d = d - 28;
											i++;
											continue;
										} else
											break Dd;
									}
								} else if (i % 12 == 4 || i % 12 == 6 || i % 12 == 9 || i % 12 == 11) {
									if (d > 30) {
										d = d - 30;
										i++;
										continue;
									} else
										break Dd;
								} else {
									if (d > 31) {
										d = d - 31;
										i++;
										continue;
									} else
										break Dd;
								}
							}
						}
						;
						
						if(i==0)
						{
							mon=12;
						}else
							mon = i % 12;
						if(i>12) {
							result.setText("" + year + "년" + mon + "월" + d + "일");
						}
						else {
						year = year - 1;
						result.setText("" + year + "년" + mon + "월" + d + "일");
						}
					} // 365클때 종료괄호
				}
				
			}
		});

		f.add(b);// 필드에 버튼 b추가
		f.add(tf1);// 필드에 텍스트 필트 1추가
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(l1);// 필드에 레이블 1 추가
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(result);
		f.setSize(500, 500);// 필드 사이즈 가로세로 500,500
		f.setLayout(null);
		f.setVisible(true);// 필드를 보이게 한다
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
