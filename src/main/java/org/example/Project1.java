package org.example;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Project1 {

    String eemail="hhhhhhhhh";
    Frame k= new Frame();
    Frame k1= new Frame();
    Frame k2= new Frame();

    public static void main(String[] args) {

        new myclass1().myclass();

    }

    void mail(String e) {

        eemail=e;
    }

    String gmail() {

        return eemail;
    }

    void hh(Frame j){

        k=j;
    }

    void hh1(Frame j){

        k1=j;
    }

    void hh2(Frame j){

        k2=j;
    }

    Frame ll() {

        return k;
    }

    Frame ll1() {

        return k1;
    }

    Frame ll2() {

        return k2;
    }

}




class myclass1{

    int ii=0;

    public void myclass(){



        Frame f = new Frame();
        f.setExtendedState(Frame.MAXIMIZED_BOTH);
        Frame f2=new Frame();
        f2.setExtendedState(Frame.MAXIMIZED_BOTH);
        Frame f3 =new Frame();
        f3.setExtendedState(Frame.MAXIMIZED_BOTH);
        Frame f4 =new Frame();
        f4.setExtendedState(Frame.MAXIMIZED_BOTH);
        newframe ob =new newframe();
        Frame f6 =new Frame();
        JButton signin= new JButton("Login");
        JButton signup1= new JButton("Signup");
        JButton b3= new JButton("");
        JPanel p =new JPanel();
        JLabel login = new JLabel("      Login / Signup -");
        JLabel email = new JLabel("  Email -");
        JLabel password = new JLabel("  Password -");
        JLabel image,eye,eyes,bank,lock;
        JLabel title = new JLabel("     Log In to Online Banking  ");
        JLabel heading=new JLabel(" BANK OF INDIA");
        JLabel Login= new JLabel("  Log In");
        JLabel secure =new JLabel("Secure Area ");
        JLabel spanish = new JLabel(" !    En espanol");
        JLabel error = new JLabel("Missing details !");
        error.hide();
        JLabel error1 =new JLabel("Invalid email or password !");
        error1.hide();
        JPanel title1 = new JPanel();
        JPanel base = new JPanel();
        JPanel down = new JPanel();
        JPanel fm = new JPanel();
        //JScrollPane s1 =new JScrollPane();
        //JScrollBar s2=new JScrollBar();

        //s1.setHorizontalScrollBarPolicy(JScrollPane);
        //s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        TextField mail=new TextField();
        TextField pass=new TextField();
        Project1 l=new Project1();




        signin.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a) {


                if((mail.getText().length()==0) || (pass.getText().length()==0)) {

                    error1.hide();
                    error.show();
                    Toolkit.getDefaultToolkit().beep();
                }


                String email1 =mail.getText();
                String pass1 =pass.getText();

                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","myproject1","MySQLPassword#0002");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from data1");

                    //System.out.println(email1);
                    while(rs.next()) {

                        if(rs.getString("email").equals(email1) && rs.getString("password").equals(pass1)) {

                            l.mail(email1);

                            f.dispose();
                            ob.frame5(l);
                        }

                        else {

                            error.hide();
                            error1.show();
                            Toolkit.getDefaultToolkit().beep();

                        }


                        //System.out.println("id = "+rs.getInt("id")+" name = "+rs.getString("name")+" age = "+rs.getInt("age"));
                        // Can be used as  ----			// 1                           // 2                       // 3
                    } //                           ------------------------------------------------------------------------------


                    rs.close();
                    stmt.close();
                    con.close();
                }catch(Exception e) {e.printStackTrace();}



                //Toolkit.getDefaultToolkit().beep();

            }

        });


        signup1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a3) {

                f.dispose();
                f2.show();

            }
        });






        Image img;
        img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\dhruv\\Downloads\\banklogo.jpg");



        ImageIcon i=new ImageIcon("C:\\Users\\dhruv\\Downloads\\bank.jpeg");
        image=new JLabel(i);
        image.setBounds(590, 190, 400, 400);


        ImageIcon eyecon= new ImageIcon("C:\\Users\\dhruv\\Downloads\\eyehide.png");
        eye=new JLabel(eyecon);

        ImageIcon sh=new ImageIcon("C:\\Users\\dhruv\\Downloads\\eyeshow.png");
        eyes=new JLabel(sh);
        eyes.hide();

        ImageIcon logo=new ImageIcon("C:\\Users\\dhruv\\Downloads\\banklogo.jpg");
        bank =new JLabel(logo);

        ImageIcon lk=new ImageIcon("C:\\Users\\dhruv\\Downloads\\lock.jpg");
        lock =new JLabel(lk);




        b3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a1) {


                if(ii==0) {
                    pass.setEchoChar((char)0);
                    ii=1;
                    eye.hide();
                    eyes.show();
                }
                else if(ii==1) {
                    pass.setEchoChar('*');
                    ii=0;
                    eyes.hide();
                    eye.show();
                }
            }

        });






        //base.setBounds(120,100,1100,800);
        base.setPreferredSize(new Dimension(1100,800));
        base.setBackground(new Color(100,100,100,20));
        base.setLayout(null);




        title.setBounds(0,0,900,70);
        title.setFont(new Font("sansserif",0,24));
        title.setForeground(Color.white);

        title1.setBounds(110,120,880,70);
        //title1.setPreferredSize(new Dimension(1800,400));
        title1.setBackground(new Color(100,0,0));
        title1.setLayout(null);


        p.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
        p.setBackground(new Color(100,100,100,50));
        p.setLayout(null);
        p.setBounds(110,260,400,265);


        down.setBounds(110,620,880,150);
        down.setBackground(new Color(100,100,0,20));



        signin.setBounds(120, 220, 90, 30);
        signup1.setBounds(250, 220, 90, 30);
        b3.setBounds(240, 170, 30, 30);
        b3.setLayout(new FlowLayout());

        login.setBounds(0, 0, 400, 30);
        login.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        login.setForeground(Color.black);


        email.setBounds(30, 60, 120, 30);
        email.setForeground(new Color(20,20,20));
        email.setFont(new Font("Segoe UI Semibold",Font.PLAIN,19));
        //username.setBorder(BorderFactory.createLineBorder(Color.black,2));


        password.setBounds(30, 140, 120, 30);
        password.setForeground(new Color(20,20,20));
        password.setFont(new Font("Segoe UI Semibold",Font.PLAIN,19));
        //password.setBorder(BorderFactory.createLineBorder(Color.black,2));


        mail.setBounds(30, 90, 200, 30);
        mail.setFont(new Font("Segoe UI Semibold",Font.PLAIN,19));


        pass.setBounds(30, 170, 200, 30);
        pass.setFont(new Font("Segoe UI Semibold",Font.PLAIN,19));
        pass.setEchoChar('*');

        heading.setBounds(150,50,170,70);
        heading.setFont(new Font("Segoe UI Semibold",Font.PLAIN,21));
        heading.setForeground(new Color(0,0,100));


        Login.setBounds(410,50,80,70);
        Login.setFont(new Font("sansserif",Font.PLAIN,19));
        Login.setForeground(Color.gray);


        secure.setBounds(830,50,880,70);
        secure.setFont(new Font("Segoe UI Semibold",Font.PLAIN,13));

        spanish.setBounds(910,50,880,70);
        spanish.setFont(new Font("sansserif",Font.PLAIN,12));


        bank.setBounds(320,60,70,50);
        lock.setBounds(807,75,20,20);

        //s1.setBounds(590, 190, 100, 100);
        //s2.setBounds(1350,30,30,700);


        error.setBounds(150, 30, 150, 30);
        error.setForeground(Color.red);
        error.setFont(new Font("sansserif",Font.PLAIN,18));

        error1.setBounds(105, 30, 240, 30);
        error1.setForeground(Color.red);
        error1.setFont(new Font("sansserif",Font.PLAIN,18));

        //fm.setBounds(5,30,1370,717);



        p.add(login);
        p.add(error);
        p.add(error1);
        p.add(email);
        p.add(password);
        p.add(mail);
        p.add(pass);
        p.add(signin);
        p.add(signup1);
        p.add(b3);
        b3.add(eye);
        b3.add(eyes);
        base.add(p);
        //image.add(s2);
        base.add(image);
        title1.add(title);
        base.add(title1);
        base.add(down);
        base.add(heading);
        base.add(spanish);
        base.add(secure);
        base.add(bank);
        base.add(lock);
        base.add(Login);
        fm.add(base);
        //f.add(fm);

        JScrollPane s1 =new JScrollPane(fm);
        s1.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
        s1.setBounds(5,30,1370,717);

        //s1.setPreferredSize(new Dimension(1100,600));

        f.add(s1);
        //f.add(s2);


        f.setSize(700,650);
        f.setTitle("this is a new frame");
        f.setLayout(null);
        //f.setVisible(true);
        f.setIconImage(img);



        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                f.dispose();
                //System.exit(0);
            }

        });






        //=======================================================================================

        //             frame 2    -  SignUp Page



        JPanel base2=new JPanel();

        Dialog welcome =new Dialog(f2,"",true);
        JLabel signup =new JLabel("Sign Up");
        JLabel line =new JLabel("You're one minute away from the best banking!  ");
        JLabel w1 =new JLabel("Welcome!");
        JLabel w2 =new JLabel("We're happy you're here.");
        JLabel n1 =new JLabel("Name");
        JLabel n2 =new JLabel("Last name");
        JLabel n3 =new JLabel("Account type");
        JLabel n31 =new JLabel("Phone number");
        JLabel n4 =new JLabel("Email");
        JLabel n41 =new JLabel("password");
        JLabel n5 =new JLabel("Amount deposit");
        JLabel n6 =new JLabel("Minimum amount needed to open Account - Rs 10,000");
        JLabel n7 =new JLabel("Invalid input ! ,Please correct your info.");
        n7.setVisible(false);
        JLabel n8 =new JLabel("Missing input ! ,Please complete your form.");
        n8.setVisible(false);
        TextField t1=new TextField();
        TextField t11=new TextField();
        Choice op=new Choice();
        TextField t3=new TextField();
        TextField t4=new TextField();
        TextField t41=new TextField();
        TextField t5=new TextField();
        JButton signupp=new JButton("Sign Up");
        JButton w3 =new JButton("Login");
        JButton passhow =new JButton("");


        JLabel eye1=new JLabel(eyecon);

        JLabel eyeshow=new JLabel(sh);
        eyeshow.hide();




        signupp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e4) {


                String pno = t5.getText(),pno1;
                pno1=t3.getText();
                int jj =0;
                long jj1=0;

                if(pno.length()!=0) {
                    jj=Integer.parseInt(pno);
                }
                if(pno1.length()==10) {
                    jj1=Long.parseLong(pno1);
                }


                if((t1.getText().length()>0) && (t11.getText().length()>0) && (jj1>999999999L) && (jj1<=9999999999L) &&
                        (t4.getText().length()>0) && (t41.getText().length()>0) && (jj>=10000)) {

                    n7.setVisible(false);
                    n8.setVisible(false);


                    //---------------------------------------- Database ------------------------------------------------


//					try{
//			            Class.forName("com.mysql.cj.jdbc.Driver");                           // dbname  //user   // password
//			            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","myproject1","MySQLPassword#0002");
//			            Statement stmt=con.createStatement();
//
//
//
//			            	String h="insert into data1 values("+0+",'"+t1.getText()+"','"+t11.getText()+"','"+op.getSelectedItem() +"',"+jj1+",'"+t4.getText()+"','"+t41.getText()+"',"+jj+");";
//
//			            	stmt.executeUpdate(h);
//
//			            stmt.close();
//			            con.close();
//			            System.out.println("system updated 1");
//				  }catch(Exception e){e.printStackTrace();}

                    //--------------------------------------------------------------------------------------------------------
                    welcome.setVisible(true);
                }


                else if((t1.getText().length()==0) || (t11.getText().length()==0) || (t3.getText().length()==0) ||
                        (t4.getText().length()==0) || (t41.getText().length()==0) || (t5.getText().length()==0)){

//					int u=t1.getText().length();
//					t5.setText(Integer.toString(u));
                    n7.setVisible(false);
                    n8.setVisible(true);
                    Toolkit.getDefaultToolkit().beep();

                }

                else if((t1.getText().length()>0) && (t11.getText().length()>0) && (jj1<=999999999L) &&
                        (t4.getText().length()>0) && (t41.getText().length()>0) &&
                        (jj<10000)){


                    n8.setVisible(false);
                    n7.setVisible(true);
                    Toolkit.getDefaultToolkit().beep();

                }
            }





        });


        w3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e5) {

                f2.dispose();
                l.mail(t4.getText());
                ob.frame5(l);
            }
        });


        base2.setBounds(420,50,450,650);
        base2.setBorder(BorderFactory.createLineBorder(Color.lightGray,4));
        base2.setLayout(null);

        signup.setFont(new Font("sansserif",Font.BOLD,35));
        signup.setBounds(160, 50, 200, 50);

        line.setBounds(60, 100, 400, 50);
        line.setFont(new Font("sansserif",Font.PLAIN,16));

        t1.setBounds(60, 220, 160, 30);
        t1.setFont(new Font("sansserif",Font.PLAIN,20));

        t11.setBounds(220, 220, 160, 30);
        t11.setFont(new Font("sansserif",Font.PLAIN,20));

        op.setBounds(60, 320, 160, 30);
        op.setFont(new Font("sansserif",Font.PLAIN,20));
        op.add("Current");
        op.add("Savings");
        op.add("Fixed Deposit");

        t3.setBounds(220, 320, 160, 30);
        t3.setFont(new Font("sansserif",Font.PLAIN,20));

        t4.setBounds(60, 420, 160, 30);
        t4.setFont(new Font("sansserif",Font.PLAIN,20));

        t41.setBounds(220, 420, 160, 30);
        t41.setFont(new Font("sansserif",Font.PLAIN,20));
        t41.setEchoChar('*');

        passhow.setBounds(380, 420, 30, 30);
        passhow.setLayout(new FlowLayout());

        t5.setBounds(60, 520, 320, 30);
        t5.setFont(new Font("sansserif",Font.PLAIN,20));

        n1.setBounds(60, 180, 120, 30);
        n1.setFont(new Font("sansserif",Font.PLAIN,20));

        n2.setBounds(220, 180, 120, 30);
        n2.setFont(new Font("sansserif",Font.PLAIN,20));

        n3.setBounds(60, 280, 160, 30);
        n3.setFont(new Font("sansserif",Font.PLAIN,20));

        n31.setBounds(220, 280, 160, 30);
        n31.setFont(new Font("sansserif",Font.PLAIN,20));

        n4.setBounds(60, 380, 160, 30);
        n4.setFont(new Font("sansserif",Font.PLAIN,20));

        n41.setBounds(220, 380, 160, 30);
        n41.setFont(new Font("sansserif",Font.PLAIN,20));

        n5.setBounds(60, 480, 320, 30);
        n5.setFont(new Font("sansserif",Font.PLAIN,20));

        n6.setBounds(43, 457, 360, 30);
        n6.setFont(new Font("sansserif",Font.PLAIN,15));

        n7.setBounds(100, 550, 320, 30);
        n7.setFont(new Font("sansserif",Font.PLAIN,15));
        n7.setForeground(Color.RED);
        n7.setBackground(new Color(0,0,0,0));

        n8.setBounds(80, 550, 320, 30);
        n8.setFont(new Font("sansserif",Font.PLAIN,15));
        n8.setForeground(Color.RED);
        n8.setBackground(new Color(0,0,0,0));

        signupp.setBounds(120, 580, 200, 40);
        signupp.setFont(new Font("sansserif",Font.BOLD,16));
        signupp.setBackground(Color.LIGHT_GRAY);
        //signupp.setBorder(BorderFactory.createLineBorder(Color.black, 0));


        w1.setFont(new Font("sansserif",Font.BOLD,39));
        w1.setBounds(155, 60, 200, 50);
        w1.setBackground(Color.black);
        w2.setFont(new Font("sansserif",Font.BOLD,16));
        w2.setBounds(150, 120, 200, 30);
        w2.setBackground(Color.black);


        w3.setBorder(BorderFactory.createCompoundBorder());
        w3.setBackground(new Color(90,90,90,50));
        w3.setBounds(180, 180, 120, 40);
        w3.setFont(new Font("sansserif",Font.BOLD,18));


        welcome.setBounds(400, 250, 495, 270);
        //welcome.setBorder(BorderFactory.createLineBorder(Color.lightGray,4));
        welcome.setLayout(null);
        welcome.setVisible(false);



        base2.add(signup);
        base2.add(t1);
        base2.add(t11);
        base2.add(op);
        base2.add(t3);
        base2.add(t4);
        base2.add(t41);
        passhow.add(eye1);
        passhow.add(eyeshow);
        base2.add(passhow);
        base2.add(t5);
        base2.add(n1);
        base2.add(n2);
        base2.add(n3);
        base2.add(n31);
        base2.add(n4);
        base2.add(n41);
        base2.add(n5);
        base2.add(n6);
        base2.add(n7);
        base2.add(n8);
        base2.add(line);
        base2.add(signupp);
        welcome.add(w1);
        welcome.add(w2);
        welcome.add(w3);
        f2.add(base2);

        f2.setLayout(null);
        f2.setSize(700,500);
        f2.setIconImage(img);
        l.hh(f2);


        passhow.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a1) {


                if(ii==0) {
                    t41.setEchoChar((char)0);
                    ii=1;
                    eye1.hide();
                    eyeshow.show();
                }
                else if(ii==1) {
                    t41.setEchoChar('*');
                    ii=0;
                    eyeshow.hide();
                    eye1.show();
                }
            }

        });



        welcome.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e4) {

                welcome.dispose();
            }
        });


        f2.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e2) {

                f2.dispose();
            }
        });


        //===================================================================================

        //frame 3   Main page ======



        ImageIcon im =new ImageIcon("C:\\Users\\dhruv\\Downloads\\background.jpg");
        JLabel f3im =new JLabel(im);
        JLabel title2=new JLabel("        BANK OF INDIA");
        JLabel title3=new JLabel("<html><p>Easily manage your bank <br> accounts and finances online</p></html>");
        ImageIcon myimg= new ImageIcon("C:\\Users\\dhruv\\Downloads\\banklogo1.jpg");
        JLabel mylogo=new JLabel(myimg);
        JLabel services =new JLabel("Popular services");
        JPanel head =new JPanel();
        JPanel basil = new JPanel();
        JButton log =new JButton("Login\\Signup");
        //JScrollBar js= new JScrollBar();
        JButton enroll =new JButton("Enroll in online banking");
        JButton account =new JButton("Open a new Account");
        JButton withdraw =new JButton("Withdrawl/deposit");


        enroll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f3.dispose();
                f2.show();
            }
        });



        log.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f3.dispose();
                f.show();
            }
        });


        account.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f3.dispose();
                f.show();
            }
        });


        withdraw.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f3.dispose();
                f.show();
            }
        });

        f3im.setBounds(0, 150, 1380, 400);
        f3im.setBorder(BorderFactory.createLineBorder(Color.BLACK) );

        //js.setBounds(1350,40,30,710);

        head.setBounds(0, 95, 1380, 75);
        head.setBackground(new Color(100,0,0));

        title2.setBounds(0, 0, 1380, 95);
        title2.setBorder(BorderFactory.createLineBorder(Color.black));
        title2.setFont(new Font("Segoe UI Semibold",Font.PLAIN,35));
        title2.setForeground(new Color(0,0,100));

        mylogo.setBounds(360, 30, 60, 40);

        title3.setBounds(500, 50, 600, 330);
        //title3.setBorder(BorderFactory.createLineBorder(Color.black));
        title3.setFont(new Font("Segoe UI Semibold",Font.BOLD,42));


        enroll.setBounds(90, 250, 270, 50);
        enroll.setFont(new Font("Segoe UI Semibold",Font.BOLD,21));
        enroll.setBackground(new Color(0,0,100));
        enroll.setForeground(Color.white);

        services.setBounds(600, 600, 250, 50);
        services.setFont(new Font("Segoe UI Semibold",Font.BOLD,32));
        //services.setBorder(BorderFactory.createLineBorder(Color.black));


        account.setBounds(300, 700, 250, 250);

        withdraw.setBounds(650, 700, 250, 250);


        log.setBounds(1200, 13, 110, 30);
        log.setBackground(Color.white);
        head.setLayout(null);

        //basil.setBounds(5,30,1370,717);

        basil.setPreferredSize(new Dimension(1300,1100));



        //basil.add(js);
        title3.add(enroll);
        f3im.add(title3);
        basil.add(f3im);
        head.add(log);
        basil.add(head);
        basil.add(title2);
        title2.add(mylogo);
        basil.add(services);
        basil.add(account);
        basil.add(withdraw);
        basil.setLayout(null);
        //basil.setSize(700,500);
        f3.setIconImage(img);
        JScrollPane jp= new JScrollPane(basil);
        //jp.setBounds(5,30,1370,717);
        jp.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
        f3.add(jp);

        f3.setSize(700,500);
        f.show();
        f2.hide();
        f3.hide();
        f4.hide();
        //f5.hide();                                                            //


        f3.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent e5) {

                f3.dispose();
            }
        });





        //===================================================================================



        //frame 4  ----- ATM Machine

        ImageIcon i3= new ImageIcon("C:\\Users\\dhruv\\Downloads\\atm-machine.jpg");
        JLabel atm=new JLabel(i3);
        JPanel pan = new JPanel();
        JPanel iu = new JPanel();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        JButton b7 = new JButton();
        JButton b8 = new JButton();
        JButton b9 = new JButton();
        JButton b0 = new JButton();
        JButton b11 = new JButton();
        JButton b22 = new JButton();
        JButton b33 = new JButton();
        JButton b44 = new JButton();
        JButton b55 = new JButton();
        JButton b66 = new JButton();

        atm.setBounds(0, 0, 1400, 800);

        pan.setBounds(315, 369, 510, 180);
        pan.setBorder(BorderFactory.createLineBorder(Color.black,4));
        pan.setBackground(Color.blue);

        //b4.setBounds(400, 600, 50, 30);

        f4.add(pan);
        f4.add(atm);
        //atm.add(b4);


        f4.setLayout(null);
        f4.setSize(700,500);
        f4.setIconImage(img);
        l.hh1(f4);

        f4.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent e5) {

                f4.dispose();
            }
        });

        //=======================================================================================


//
//
//		// f5 ============= Signed-in page ===============
//
//
//
//
//
//			String uname="";
//			String lname="";
//			String account1="";
//			int id=0;
//			int phone=0;
//			int amount=0;
//			 Panel pp= new Panel();
//
//			f4.addWindowListener(new WindowAdapter() {
//
//
//				public void windowOpened(WindowEvent e5) {
//
//					pp.setBackground(Color.black);
//				}
//			});
//
//
//	//==========================================================================================================
//			if(pp.getBackground()==Color.black) {
//
//
//				try {
//
//					Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","myproject1","MySQLPassword#0002");
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery("select * from data1 where email = '"+l.gmail()+"';");
//
//				uname =rs.getString("name");
//				lname =rs.getString("lastname");
//				account1 =rs.getString("account");
//				id =rs.getInt("id");
//				phone =rs.getInt("phone");
//				amount =rs.getInt("amount");
//
//				//while(rs.next()) {
//
//
//					//System.out.println("id = "+rs.getInt("id")+" name = "+rs.getString("name")+" age = "+rs.getInt("age"));
//			         // Can be used as  ----			// 1                           // 2                       // 3
//				//} //                           ------------------------------------------------------------------------------
//
//
//				rs.close();
//				stmt.close();
//				con.close();
//				}catch(Exception e) {e.printStackTrace();}
//
//
//			}
//		//=================================================================================================================
//
//
//			ImageIcon im1 =new ImageIcon("C:\\Users\\dhruv\\Downloads\\background.jpg");
//			JLabel f3im1 =new JLabel(im);
//			JLabel title21=new JLabel("        BANK OF INDIA");
//			JLabel title31=new JLabel("<html><p>Welcome <br>"+uname+lname+".</p></html>");
//			ImageIcon myimg1= new ImageIcon("C:\\Users\\dhruv\\Downloads\\banklogo1.jpg");
//			JLabel mylogo1=new JLabel(myimg);
//			JLabel services1 =new JLabel("Popular services");
//			JLabel tt =new JLabel("Your account details -");
//			JLabel tt1 =new JLabel("Account owner : "+uname+lname);
//			JLabel tt2 =new JLabel("   Account type : "+account);
//			JLabel tt3 =new JLabel("         Owner id : "+Integer.toString(id));
//			JLabel tt4 =new JLabel("       Phone no. : "+Integer.toString(phone));
//			JLabel tt5 =new JLabel("           Balance : "+Integer.toString(amount));
//			JPanel head1 =new JPanel();
//			JScrollBar js1= new JScrollBar();
//			JButton newaccount1 =new JButton("Open a new Account");
//			JButton withdraw1 =new JButton("Withdrawl/deposit");
//			JButton CV =new JButton("Check your CV");
//
//
//			if(pp.getBackground()==Color.black) {
//
//
//
//
//			}
//
//
//			newaccount1.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e6) {
//
//					f5.dispose();
//					f2.show();
//				}
//			});
//
//
//			withdraw1.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e6) {
//
//					f5.dispose();
//					f4.show();
//				}
//			});
//
//
//			CV.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e7) {
//
//					f5.dispose();
//					f6.show();
//				}
//			});
//
//			f3im1.setBounds(0, 150, 1380, 200);
//			f3im1.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
//
//			js1.setBounds(1350,40,30,710);
//
//			head1.setBounds(0, 95, 1380, 75);
//			head1.setBackground(new Color(100,0,0));
//
//			title21.setBounds(0, 0, 1380, 95);
//			title21.setBorder(BorderFactory.createLineBorder(Color.black));
//			title21.setFont(new Font("Segoe UI Semibold",Font.PLAIN,35));
//			title21.setForeground(new Color(0,0,100));
//
//			mylogo1.setBounds(360, 30, 60, 40);
//
//			title31.setBounds(500, 50, 600, 150);
//			//title3.setBorder(BorderFactory.createLineBorder(Color.black));
//			title31.setFont(new Font("Segoe UI Semibold",Font.BOLD,42));
//
//
//			services1.setBounds(600, 600, 250, 50);
//			services1.setFont(new Font("Segoe UI Semibold",Font.BOLD,32));
//			//services.setBorder(BorderFactory.createLineBorder(Color.black));
//
//
//			tt.setBounds(300, 370, 250, 30);
//			tt.setFont(new Font("Segoe UI Semibold",Font.BOLD,24));
//
//			tt1.setBounds(350, 420, 250, 30);
//			tt1.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));
//
//			tt2.setBounds(350, 455, 250, 30);
//			tt2.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));
//
//			tt3.setBounds(350, 490, 250, 30);
//			tt3.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));
//
//			tt4.setBounds(350, 525, 250, 30);
//			tt4.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));
//
//			tt5.setBounds(350, 560, 250, 30);
//			tt5.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));
//
//			newaccount1.setBounds(200, 700, 250, 250);
//
//			withdraw1.setBounds(550, 700, 250, 250);
//
//			CV.setBounds(900, 700, 250, 250);
//
//
//
//
//
//			f5.add(js1);
//			f3im1.add(title31);
//			f5.add(f3im1);
//			f5.add(head1);
//			f5.add(title21);
//			title21.add(mylogo1);
//			f5.add(services1);
//			f5.add(newaccount1);
//			f5.add(withdraw1);
//			f5.add(CV);
//			f5.add(tt);
//			f5.add(tt1);
//			f5.add(tt2);
//			f5.add(tt3);
//			f5.add(tt4);
//			f5.add(tt5);
//
//
//
//
//			f5.setLayout(null);
//			f5.setSize(700,500);
//
//			f5.addWindowListener(new WindowAdapter() {
//
//				public void windowClosing(WindowEvent e6) {
//
//					f5.dispose();
//				}
//			});
//
//


        //=========================================================================================

        // ================ frame 6 ===================


        f6.setSize(700,500);
        f6.setIconImage(img);
        l.hh2(f6);

        f6.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e8) {

                f6.dispose();
            }
        });



    }
    public void mpl(){



    }

}





//===========================================================================================

class newframe extends myclass1{



    void frame5(Project1 l1){





        // f5 ============= Signed-in page ===============



        //  mymail
        //  mypass


        Frame f5= new Frame();
        f5.setExtendedState(Frame.MAXIMIZED_BOTH);

        String uname="";
        String lname="";
        String account1="";
        int id=0;
        long phone=0;
        int amount=0;



// 						f4.addWindowListener(new WindowAdapter() {
//
//
// 							public void windowOpened(WindowEvent e5) {
//
// 								pp.setBackground(Color.black);
// 							}
// 						});


        //==========================================================================================================
// 						if(pp.getBackground()==Color.black) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","myproject1","MySQLPassword#0002");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from data1 where email = '"+l1.gmail()+"';");
            rs.next();

            uname =rs.getString("name");
            lname =rs.getString("lastname");
            account1 =rs.getString("account");
            id =rs.getInt("id");
            phone =rs.getLong("phone");
            amount =rs.getInt("amount");

            //while(rs.next()) {


            //System.out.println("id = "+rs.getInt("id")+" name = "+rs.getString("name")+" age = "+rs.getInt("age"));
            // Can be used as  ----			// 1                           // 2                       // 3
            //} //                           ------------------------------------------------------------------------------


            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e) {e.printStackTrace();}


// 						}
        //=================================================================================================================


        ImageIcon im1 =new ImageIcon("C:\\Users\\dhruv\\Downloads\\background.jpg");
        JLabel f3im1 =new JLabel(im1);
        JLabel title21=new JLabel("        BANK OF INDIA");
        JLabel title31=new JLabel("<html><p>Welcome <br>"+uname+" "+lname+".</p></html>");
        ImageIcon myimg1= new ImageIcon("C:\\Users\\dhruv\\Downloads\\banklogo1.jpg");
        Image im= Toolkit.getDefaultToolkit().getImage("C:\\Users\\dhruv\\Downloads\\banklogo1.jpg");
        JLabel mylogo1=new JLabel(myimg1);
        JLabel services1 =new JLabel("Popular services");
        JLabel tt =new JLabel("Your account details -");
        JLabel tt1 =new JLabel("Account owner : "+uname+" "+lname);
        JLabel tt2 =new JLabel("Account type    : "+account1);
        JLabel tt3 =new JLabel("Owner id          : "+Integer.toString(id));
        JLabel tt4 =new JLabel("Phone no.        : "+Long.toString(phone));
        JLabel tt5 =new JLabel("Balance            : "+Integer.toString(amount));
        JPanel head1 =new JPanel();
        //JScrollBar js1= new JScrollBar();
        JButton newaccount1 =new JButton("Open a new Account");
        JButton withdraw1 =new JButton("Withdrawl/deposit");
        JButton CV =new JButton("Check your CV");


// 						if(pp.getBackground()==Color.black) {
//
//
//
//
// 						}


        newaccount1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f5.dispose();
                l1.ll().show();
                //f2.show();
            }
        });



        withdraw1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e6) {

                f5.dispose();
                l1.ll1().show();
                //f4.show();
            }
        });


        CV.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e7) {

                f5.dispose();
                l1.ll2().show();
                //f6.show();
            }
        });

        f3im1.setBounds(0, 150, 1380, 200);
        f3im1.setBorder(BorderFactory.createLineBorder(Color.BLACK) );

        //js1.setBounds(1350,40,30,710);

        head1.setBounds(0, 95, 1380, 75);
        head1.setBackground(new Color(100,0,0));

        title21.setBounds(0, 0, 1380, 95);
        title21.setBorder(BorderFactory.createLineBorder(Color.black));
        title21.setFont(new Font("Segoe UI Semibold",Font.PLAIN,35));
        title21.setForeground(new Color(0,0,100));

        mylogo1.setBounds(360, 30, 60, 40);

        title31.setBounds(500, 50, 600, 150);
        //title3.setBorder(BorderFactory.createLineBorder(Color.black));
        title31.setFont(new Font("Segoe UI Semibold",Font.BOLD,42));


        services1.setBounds(600, 600, 250, 50);
        services1.setFont(new Font("Segoe UI Semibold",Font.BOLD,32));
        //services.setBorder(BorderFactory.createLineBorder(Color.black));


        tt.setBounds(300, 370, 250, 30);
        tt.setFont(new Font("Segoe UI Semibold",Font.BOLD,24));

        tt1.setBounds(350, 420, 300, 30);
        tt1.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));

        tt2.setBounds(350, 455, 250, 30);
        tt2.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));

        tt3.setBounds(350, 490, 250, 30);
        tt3.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));

        tt4.setBounds(350, 525, 280, 30);
        tt4.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));

        tt5.setBounds(350, 560, 250, 30);
        tt5.setFont(new Font("Segoe UI Semibold",Font.BOLD,20));

        newaccount1.setBounds(200, 700, 250, 250);

        withdraw1.setBounds(550, 700, 250, 250);

        CV.setBounds(900, 700, 250, 250);


        JPanel yt= new JPanel();
        yt.setLayout(null);
        yt.setPreferredSize(new Dimension(1300,1100));
        //yt.setBounds(5,30,1370,717);


        //yt.add(js1);
        f3im1.add(title31);
        yt.add(f3im1);
        yt.add(head1);
        yt.add(title21);
        title21.add(mylogo1);
        yt.add(services1);
        yt.add(newaccount1);
        yt.add(withdraw1);
        yt.add(CV);
        yt.add(tt);
        yt.add(tt1);
        yt.add(tt2);
        yt.add(tt3);
        yt.add(tt4);
        yt.add(tt5);

        JScrollPane jj= new JScrollPane(yt);
        jj.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
        jj.setBounds(5,30,1370,717);

        //jj.setSize(new Dimension(1370,717));


        f5.add(jj);



        f5.setLayout(null);
        f5.setSize(700,500);
        f5.setIconImage(im);

        f5.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e6) {

                f5.dispose();
            }
        });



        f5.show();

    }

}








