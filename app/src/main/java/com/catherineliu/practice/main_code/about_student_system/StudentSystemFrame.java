//package com.catherineliu.practice.main_code.about_student_system;
//
//import android.widget.GridLayout;
//
//import com.google.android.material.internal.FlowLayout;
//
///**
// * 项目：Practice
// * 文件描述：学生管理系统UI框架部分
// * 作者：ljj
// * 创建时间：2020/6/22
// */
//public class StudentSystemFrame {
//    JFrame jf=new JFrame("ѧ����Ϣ����ϵͳ");
//    JMenuBar jmb=new JMenuBar();
//    GridLayout gr=new GridLayout();//���񲼾�
//    FlowLayout fl=new FlowLayout();//��ˮ����
//    BorderLayout blo=new BorderLayout();//�߽粼��
//    CardLayout card=new CardLayout();//��Ƭ����
//    JTabbedPane jtp=new JTabbedPane();//ѡ�
//    ButtonGroup bg=new ButtonGroup();
//
//    JPanel jp1=new JPanel(fl);//���jp1
//    JPanel jp2=new JPanel();
//    JPanel jp3=new JPanel();
//    JPanel jp4=new JPanel();
//    JPanel jp5=new JPanel();
//    JPanel jp6=new JPanel();
//    JPanel jp7=new JPanel();
//
//    void test0(){
//        //JFrame jf=new JFrame();
//        //JMenuBar jmb=new JMenuBar();//����һ���˵��ռ�;�˵���
//        //FlowLayout fl=new FlowLayout();
//        //JMenu jmbxj=new JMenu("�½�");
//        JMenu jmbbj=new JMenu("�༭");
//        JMenu jmbfile=new JMenu("�ļ�");
//        JMenuItem jmbxj=new JMenuItem("�½�");
//        JMenuItem jmbdk=new JMenuItem("��");
//        JMenuItem jmbbc=new JMenuItem("����");
//
//        jf.setLayout(fl);
//        jf.setJMenuBar(jmb);//
//        jf.setLayout(new BorderLayout());//����߽粼��
//        jmb.add(jmbfile);
//        jmb.add(jmbbj);
//        jmbfile.add(jmbxj);
//        jmbfile.add(jmbdk);
//        jmbfile.add(jmbbc);
//
//        jtp.add(jp1,0);
//        jtp.setTitleAt(0,"¼��ѧ����Ϣ" );
//        jtp.add(jp2,1);
//        jtp.setTitleAt(1, "��ʾѧ����Ϣ");
//        jtp.add(jp3,2);
//        jtp.setTitleAt(2, "����ѧ����Ϣ");
//        jtp.add(jp4,3);
//        jtp.setTitleAt(3, "�޸�ѧ����Ϣ");
//        jtp.add(jp5,4);
//        jtp.setTitleAt(4, "����ѧ����Ϣ");
//        jtp.add(jp6,5);
//        jtp.setTitleAt(5, "���ѧ����Ϣ");
//        jtp.add(jp7,6);
//        jtp.setTitleAt(6, "ɾ��ѧ����Ϣ");
//        jf.add(jtp);
//        jf.setSize(800,500);//���ô����С
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);//����ɼ�
//    }
//
//    void test1(){
//        JTextField jtfname=new JTextField(10);
//        JTextField jtfnum=new JTextField(10);
//        JTextField jtfage=new JTextField(10);
//        JLabel jlname=new JLabel("������");
//        JLabel jlsex=new JLabel("�Ա�            ");
//        JRadioButton jrwoman=new JRadioButton("��");
//        JRadioButton jrman=new JRadioButton("Ů");
//        bg.add(jrwoman);
//        bg.add(jrman);
//        JLabel jlage=new JLabel("���䣺");
//        JLabel jlnum=new JLabel("ѧ�ţ�");
//        JButton jrsure=new JButton();
//        JButton jrcancel=new JButton();
//        jrsure.setText("ȷ��");
//        jrcancel.setText("ȡ��");
//        bg.add(jrsure);
//        bg.add(jrcancel);
//
//
//        JPanel j11=new JPanel();
//        JPanel j12=new JPanel();
//        JPanel j13=new JPanel();
//        JPanel j14=new JPanel();
//        JPanel j15=new JPanel();
//
//        jp1.setLayout(new GridLayout(10,0));
//        j11.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j11.add(jlname);
//        j11.add(jtfname);
//        j12.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j12.add(jlsex);
//        j12.add(jrwoman);
//        j12.add(jrman);
//        j13.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j13.add(jlnum);
//        j13.add(jtfnum);
//        j14.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j14.add(jrsure);
//        j14.add(jrcancel);
//        j15.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j15.add(jlage);
//        j15.add(jtfage);
//        jp1.add(j11);
//        jp1.add(j12);
//        jp1.add(j13);
//        jp1.add(j15);
//        jp1.add(j14);
//        jp1.setVisible(true);
//        jf.setSize(800,500);//���ô����С
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);//����ɼ�
//    }
//
//    void test2(){
//
//    }
//
//    void test3(){
//
//        jp3.setLayout(new GridLayout(10,0));
//        JPanel jp30=new JPanel();
//        final JPanel jp31=new JPanel();
//        JPanel jp32=new JPanel();
//        JPanel jp33=new JPanel();
//        JPanel jp34=new JPanel();
//
//        jp32.setLayout(new CardLayout());
//
//        JPanel j31=new JPanel();
//        JPanel j32=new JPanel();
//        JPanel j33=new JPanel();
//        JPanel j34=new JPanel();
//        JPanel j35=new JPanel();
//        JPanel j36=new JPanel();
//        JPanel j37=new JPanel();
//        JPanel j38=new JPanel();
//        JPanel j39=new JPanel();
//        j31.setLayout(fl);
//        j32.setLayout(fl);
//        j33.setLayout(fl);
//        j34.setLayout(fl);
//        j35.setLayout(fl);
//        j36.setLayout(fl);
//        j37.setLayout(fl);
//        j38.setLayout(fl);
//        j39.setLayout(fl);
//
//        JButton jbcname=new JButton("����������");
//        JButton jbcnum=new JButton("��ѧ�Ų���");
//        JButton jbcage=new JButton("���������");
//
//        JLabel jlcname=new JLabel("��������ҵ����֣�");
//        JLabel jlcnum=new JLabel("��������ҵ�ѧ�ţ�");
//        JLabel jlcage=new JLabel("��������ҵ����䣺");
//
//        JTextField jtcname=new JTextField(10);
//        JTextField jtcnum=new JTextField(10);
//        JTextField jtcage=new JTextField(10);
//
//        JButton jrsure1=new JButton("ȷ��");
//        JButton jrcancel1=new JButton("ȡ��");
//        JButton jrsure2=new JButton("ȷ��");
//        JButton jrcancel2=new JButton("ȡ��");
//        JButton jrsure3=new JButton("ȷ��");
//        JButton jrcancel3=new JButton("ȡ��");
//
//        j32.add(jlcname);
//        j32.add(jtcname);
//        j36.add(jrsure1);
//        j36.add(jrcancel1);
//        j33.add(jlcnum);
//        j33.add(jtcnum);
//        j37.add(jrsure2);
//        j37.add(jrcancel2);
//        j34.add(jlcage);
//        j34.add(jtcage);
//        j38.add(jrsure3);
//        j38.add(jrcancel3);
//
//        jp30.add(jbcname);
//        jp30.add(jbcnum);
//        jp30.add(jbcage);
//
//        jp32.setLayout(fl);
//        jp33.setLayout(fl);
//        jp34.setLayout(fl);
//        jp32.add(j32);
//        jp32.add(j36);
//        jp33.add(j33);
//        jp33.add(j37);
//        jp34.add(j34);
//        jp34.add(j38);
//        jp31.setLayout(card);
//        jp31.add(jp32);
//        jp31.add(jp33);
//        jp31.add(jp34);
//
//        jp3.add(jp30,"North");
//        jp3.add(jp31,"Center");
//
//
//        jbcname.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.first(jp31);
//
//            }
//        });
//        jbcnum.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.next(jp31);
//
//            }
//        });
//        jbcage.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.last(jp31);
//
//            }
//        });
//        jf.setSize(800,500);//���ô����С
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);//����ɼ�
//    }
//
//    void test4(){
//        JLabel jlxnum=new JLabel("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
//        JTextField jtfxnum=new JTextField(10);
//        JButton jbxsure=new JButton("ȷ��");
//        JButton jbxcancel=new JButton("ȡ��");
//
//        JTextField jtfaname=new JTextField(10);
//        JTextField jtfaage=new JTextField(10);
//        JLabel jlaname=new JLabel("������");
//        JLabel jlasex=new JLabel("�Ա�            ");
//        JRadioButton jrawoman=new JRadioButton("��");
//        JRadioButton jraman=new JRadioButton("Ů");
//        bg.add(jrawoman);
//        bg.add(jraman);
//        JLabel jlaage=new JLabel("���䣺");
//        JButton jrasure=new JButton();
//        JButton jracancel=new JButton();
//        jrasure.setText("ȷ��");
//        jracancel.setText("ȡ��");
//        bg.add(jrasure);
//        bg.add(jracancel);
//
//        JPanel jp41=new JPanel();
//        JPanel j41=new JPanel();
//        JPanel j42=new JPanel();
//        JPanel j43=new JPanel();
//        JPanel j44=new JPanel();
//        JPanel j45=new JPanel();
//        JPanel j46=new JPanel();
//        final JPanel j47=new JPanel();
//
//
//        j41.setLayout(fl);
//        j41.add(jlxnum);
//        j41.add(jtfxnum);
//        j41.add(jbxsure);
//        j41.add(jbxcancel);
//
//        j42.setLayout(fl);
//        j42.add(jlaname);
//        j42.add(jtfaname);
//
//        j43.setLayout(fl);
//        j43.add(jlasex);
//        j43.add(jrawoman);
//        j43.add(jraman);
//
//        j44.setLayout(fl);
//        j44.add(jlaage);
//        j44.add(jtfaage);
//
//        j45.setLayout(fl);
//        j44.add(jrasure);
//        j44.add(jracancel);
//
//        j46.setLayout(new GridLayout(10,0));
//        j46.add(j42);
//        j46.add(j43);
//        j46.add(j44);
//        j46.add(j45);
//
//        j47.setLayout(card);
//        j47.add(jp41);
//        j47.add(j46);
//
//		/*jp41.setLayout(blo);
//		jp41.add(j41,"North");
//		jp41.add(j47,"Center");*/
//
//        jp4.setLayout(blo);
//        jp4.add(j41,"North");
//        jp4.add(j47);
//        jbxsure.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.last(j47);
//
//            }
//        });
//        jbxcancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.first(j47);
//
//            }
//        });
//        jf.setSize(800,500);//���ô����С
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);//����ɼ�
//    }
//
//    void test5(){
//        JButton jbpname=new JButton("����������");
//        JButton jbpage=new JButton("����������");
//        JButton jbpnum=new JButton("��ѧ������");
//
//        JPanel j51=new JPanel();
//
//        j51.setLayout(new GridLayout(10,0));
//        j51.add(jbpname);
//        j51.add(jbpage);
//        j51.add(jbpnum);
//
//        jp5.add(j51);
//
//		/*jf.setSize(800,500);//���ô����С
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);//����ɼ�*/
//    }
//
//    void test6(){
//        JTextField jtftname=new JTextField(10);
//        JTextField jtftnum=new JTextField(10);
//        JTextField jtftage=new JTextField(10);
//        JLabel jltname=new JLabel("������");
//        JLabel jltsex=new JLabel("�Ա�            ");
//        JRadioButton jrtwoman=new JRadioButton("��");
//        JRadioButton jrtman=new JRadioButton("Ů");
//        bg.add(jrtwoman);
//        bg.add(jrtman);
//        JLabel jltage=new JLabel("���䣺");
//        JLabel jltnum=new JLabel("ѧ�ţ�");
//        JButton jrtsure=new JButton();
//        JButton jrtcancel=new JButton();
//        jrtsure.setText("ȷ��");
//        jrtcancel.setText("ȡ��");
//        bg.add(jrtsure);
//        bg.add(jrtcancel);
//
//
//        JPanel j61=new JPanel();
//        JPanel j62=new JPanel();
//        JPanel j63=new JPanel();
//        JPanel j64=new JPanel();
//        JPanel j65=new JPanel();
//
//        jp6.setLayout(new GridLayout(10,0));
//        j61.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j61.add(jltname);
//        j61.add(jtftname);
//        j62.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j62.add(jltsex);
//        j62.add(jrtwoman);
//        j62.add(jrtman);
//        j63.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j63.add(jltnum);
//        j63.add(jtftnum);
//        j64.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j64.add(jrtsure);
//        j64.add(jrtcancel);
//        j65.setLayout(new FlowLayout(/*FlowLayout.LEFT*/));
//        j65.add(jltage);
//        j65.add(jtftage);
//        jp6.add(j61);
//        jp6.add(j62);
//        jp6.add(j63);
//        jp6.add(j65);
//        jp6.add(j64);
//        jp6.setVisible(true);
//        jf.setSize(800,500);//���ô����С
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);//����ɼ�
//
//    }
//
//    void test7(){
//        JLabel jlsnum=new JLabel("������Ҫɾ����ѧ��ѧ�ţ�");
//        JTextField jtfsnum=new JTextField(10);
//        JButton jbs1sure=new JButton("ȷ��");
//        JButton jbs1cancel=new JButton("ȡ��");
//        JLabel jlsc=new JLabel("ȷ��Ҫɾ����");
//        JButton jbssure=new JButton("ȷ��");
//        JButton jbscancel=new JButton("ȡ��");
//
//        JPanel j71=new JPanel();
//        JPanel j72=new JPanel();
//        final JPanel j73=new JPanel();
//        JPanel j74=new JPanel();
//        JPanel j75=new JPanel();
//        JPanel j76=new JPanel();
//
//        j71.setLayout(fl);
//        j71.add(jlsnum);
//        j71.add(jtfsnum);
//
//        j74.setLayout(fl);
//        j74.add(jbs1sure);
//        j74.add(jbs1cancel);
//
//        j76.setLayout(new GridLayout(2,0));
//        j76.add(j71);
//        j76.add(j74);
//
//        j72.setLayout(fl);
//        j72.add(jlsc);
//        j72.add(jbssure);
//        j72.add(jbscancel);
//
//        j73.setLayout(card);
//        j73.add(j75);
//        j73.add(j72);
//
//        jp7.setLayout(blo);
//        jp7.add(j76,"North");
//        jp7.add(j73,"Center");
//
//        jbs1sure.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.last(j73);
//            }
//        });
//        jbs1cancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.first(j73);
//            }
//        });
//    }
//    public class FirstFrame{
//        public void main(String[] args) {
//
//            Frame f=new Frame();
//            f.test0();
//            f.test1();
//            f.test2();
//            f.test3();
//            f.test4();
//            f.test5();
//            f.test6();
//            f.test7();
//
//        }
//    }
//
//}
