
//���� �ڵ�
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class calendar03 {

	public static void main(String[] args) {
		JFrame f = new JFrame("calendar");

		JLabel l1 = new JLabel("���۳⵵(ex:2020)");
		JTextField tf1 = new JTextField();
		JLabel l2 = new JLabel("���� ��(ex:05)");
		JTextField tf2 = new JTextField();
		JLabel l3 = new JLabel("���� ��(ex:31)");
		JTextField tf3 = new JTextField();
		JLabel l4 = new JLabel("���� �� ��(ex:200)");
		JTextField tf4 = new JTextField();
		JLabel result = new JLabel();

		l1.setBounds(50, 100, 300, 30);// l1�� ������50, �Ʒ���100�� ��ġ
		l2.setBounds(50, 140, 300, 30);// l2�� ����300, ����30 ũ��
		l3.setBounds(50, 180, 300, 30);
		l4.setBounds(50, 220, 300, 30);

		tf1.setBounds(200, 100, 200, 30);
		tf2.setBounds(200, 140, 200, 30);
		tf3.setBounds(200, 180, 200, 30);
		tf4.setBounds(200, 220, 200, 30);

		result.setBounds(200, 260, 300, 30);

		JButton b = new JButton("���� ���");
		b.setBounds(150, 340, 200, 30);
		
		l1.setFont(new Font ("���� ���",Font.BOLD,15));
		l2.setFont(new Font ("���� ���",Font.BOLD,15));
		l3.setFont(new Font ("���� ���",Font.BOLD,15));
		l4.setFont(new Font ("���� ���",Font.BOLD,15));
		
		tf1.setFont(new Font ("���� ���",Font.BOLD,15));
		tf2.setFont(new Font ("���� ���",Font.BOLD,15));
		tf3.setFont(new Font ("���� ���",Font.BOLD,15));
		tf4.setFont(new Font ("���� ���",Font.BOLD,15));
		
		result.setFont(new Font ("���� ���",Font.BOLD,15));
		b.setFont(new Font ("���� ���",Font.BOLD,15));

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int year, mon, day;// ���� ��¥
				int D;// ���� �� ��
				int d = 0;// ����� ���� �� �� , ���� ���� �� ��
				int x, i;// �ݺ��� ����Ƚ�� ���� ����,�ݺ����� �μ�,
				int Nyear;// �������� ���� �⵵�� ��� ������ ����
				int Q;// ���̰�� ����

				year = Integer.parseInt(tf1.getText());
				mon = Integer.parseInt(tf2.getText());
				day = Integer.parseInt(tf3.getText());
				D = Integer.parseInt(tf4.getText());

				D365: {
					if (D < 365) {
					
						if (mon == 2) {// �Է� ���� 2���� ��
							if ( year % 400 == 0||year%100!=0&&year % 4 == 0 ) {// ��������
								x = D - (29 - day);// ���� �ϼ� ���
								if (x <= 0) {// ���� �� ���� ������ ��
									if ((D + day) <= 29) {
										result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
										break D365;
									}
								} else {
									mon++;
									d = x;
								}
									
							} else {// ������ �ƴ� ��
								x = D - (28 - day);
								if (x <= 0) {
									if ((D + day) <= 28) {
										result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
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
									result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
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
									result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}

						}

						i = mon;
						Nyear = year;// �������� ���� �⵵���� ������

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
						result.setText("" + year + "��" + mon + "��" + d + "��");
					}

					if (D == 365) {
						if ( year % 400 == 0||year%100!=0&&year % 4 == 0) {
							if (mon == 1 || mon == 2) {// ���� 1�� �Ǵ� 2���� ��
								if (mon == 1 && day == 1) { // ���� 1��1���� ��
									mon = 12;
									day = 31;
									result.setText("" + year + "��" + mon + "��" + day + "��");
									break D365;
								} else {
									year = year + 1;
									day = day - 1;
									result.setText("" + year + "��" + mon + "��" + day + "��");
									break D365;
								}
							} else {
								year = year + 1;
								result.setText("" + year + "��" + mon + "��" + day + "��");
							}

						}

						else {
							year = year + 1;
							if ( year % 400 == 0||year%100!=0&&year % 4 == 0) {
								if (mon <= 2)
									result.setText("" + year + "��" + mon + "��" + day + "��");
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
								result.setText("" + year + "��" + mon + "��" + day + "��");
							} else
								result.setText("" + year + "��" + mon + "��" + day + "��");

							break D365;
						}
					}

					else if (D > 365) {
						Nyear = year;
						Q = 0;
						if (mon > 2) {// 2�� ������ ��
							First: {
								while (true) {// ���ѷ���
									if ( Nyear % 4 != 0||Nyear%100==0&&Nyear % 400 != 0) {// �ش� �⵵�� ������ �ƴҰ��
										if ((Nyear + 1) % 4 != 0 ||(Nyear+1)%100==0&& (Nyear + 1) % 400 != 0) {// ���� �⵵�� ������ �ƴϸ�
											if (D >= Q && (Q + 365) <= D) {//���̰� ��갪���� ū ���
												Q = Q + 365;
												Nyear++;
											} else {
												Nyear++;
												year = Nyear;
												D = D - Q;
												break First;
											}
										} else {// �����⵵�� �����̸�
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

									else {// �ش� �⵵�� �����̸�
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

						} else {// 2�� ������ ��
							Secon: {
								while (true) {
									if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {// �ش�⵵�� ������ ���
										if (D >= Q&&(Q+366)<=D) {
										
												Q = Q + 366;
												Nyear++;
											
										} else {
											Nyear++;
											year = Nyear;
											D = D - Q;
											break Secon;
										}

									} else {// ������ �ƴ� ���
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
						DD: {//���� �ڵ忡 �������� ����� ���� ��Ȯ�� �⵵ ��� �뵵
							for (;;) {
								if (i % 12 == 2) {
									if (i < 12)
										Nyear--;//�ظ� �ѱ��� ���� ��� ���� ������ 1��ŭ �۾ƾ� ��
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
						

			
						
						if (mon == 2) {// �Է� ���� 2���� ��
							if ( Nyear % 400 == 0||Nyear%100!=0&&Nyear % 4 == 0) {// ��������
								x = D - (29 - day);// ���� �ϼ� ���
								if (x <= 0) {// ���� �� ���� �����̰ų� 0�� ��
									if ((D + day) <= 29) {
										year--;//�ظ� �ȳѰ����Ƿ� ���� �⵵���� 1�� ��
										result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
										break D365;
									}
								} else
								{
									mon++;
									d = x;
								}
							} else {// ������ �ƴ� ��
								x = D - (28 - day);
								if (x <= 0) {
									if ((D + day) <= 28) {
										year--;
										result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
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
									result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
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
									result.setText("" + year + "��" + mon + "��" + (D + day) + "��");
									break D365;
								}
							} else
							{
								mon++;
								d = x;
							}

						}

						i = mon;
						Nyear = year;// �������� ���� �⵵���� ������

						Dd: {
							for (;;) {
								if (i % 12 == 2) {
									if (i < 12)
										Nyear--;//�ظ� �ѱ��� ���� ��� ���� ������ 1��ŭ �۾ƾ� ��
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
							result.setText("" + year + "��" + mon + "��" + d + "��");
						}
						else {
						year = year - 1;
						result.setText("" + year + "��" + mon + "��" + d + "��");
						}
					} // 365Ŭ�� �����ȣ
				}
				
			}
		});

		f.add(b);// �ʵ忡 ��ư b�߰�
		f.add(tf1);// �ʵ忡 �ؽ�Ʈ ��Ʈ 1�߰�
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(l1);// �ʵ忡 ���̺� 1 �߰�
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(result);
		f.setSize(500, 500);// �ʵ� ������ ���μ��� 500,500
		f.setLayout(null);
		f.setVisible(true);// �ʵ带 ���̰� �Ѵ�
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
