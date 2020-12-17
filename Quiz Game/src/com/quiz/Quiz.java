package com.quiz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.Font;


public class Quiz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<Question> quiz =new ArrayList<Question>();
	int count = 0;
	JTextPane questionView;
	JRadioButton response2;
	JRadioButton response1;
	JRadioButton response3;
	JLabel level3;
	JLabel level2;
	JLabel level1;
	ButtonGroup buttonGroup;
	JLabel pointsTextView;
	JLabel countDownTextView;
	int left_time = 300;
	ActionListener countDown;
	SoundSystem soundSystem;
	int score = 0;
	Player player;
	Timer timer;
	JButton valide;
	JButton next;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz frame = new Quiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	
	public Quiz() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		soundSystem = new SoundSystem();
		temp_db();
		startTimer();
		player = new Player(false, false, false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pointsTextView = new JLabel();
		pointsTextView.setText("Points 000/ 100");
		pointsTextView.setBounds(15, 4, 115, 20);
		contentPane.add(pointsTextView);
		
		countDownTextView = new JLabel();
		countDownTextView.setText("00:00");
		countDownTextView.setBounds(625, -5, 73, 39);
		contentPane.add(countDownTextView);
		
		questionView = new JTextPane();
		questionView.setFont(new Font("Stencil", Font.BOLD, 18));
		questionView.setBounds(89, 40, 477, 298);
		questionView.setEditable(false);
		
		//questionView.setWrapStyleWord(true);
		//questionView.setLineWrap(true);
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		questionView.setParagraphAttributes(attribs, true);
		questionView.setBackground(UIManager.getColor("Label.background"));
		contentPane.add(questionView);
		
		response1 = new JRadioButton();
		response1.setText("----------------");
		response1.setBounds(0, 340, 698, 53);
		contentPane.add(response1);
		response1.setName("1");
		
		response2 = new JRadioButton();
		response2.setText("----------------");
		response2.setBounds(0, 401, 698, 53);
		contentPane.add(response2);
		response2.setName("2");
		
		response3 = new JRadioButton();
		response3.setText("----------------");
		response3.setBounds(0, 462, 698, 53);
		contentPane.add(response3);
		response3.setName("3");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(response1);
		buttonGroup.add(response2);
		buttonGroup.add(response3);
		level1 = new JLabel("Niveau 1", SwingConstants.CENTER);
		level1.setOpaque(true);
		level1.setBounds(246, 4, 84, 29);
		contentPane.add(level1);
		
		level2 = new JLabel("Niveau 2", SwingConstants.CENTER);
		level2.setOpaque(true);
		level2.setBounds(325, 4, 84, 29);
		contentPane.add(level2);
		level3 = new JLabel("Niveau 3", SwingConstants.CENTER);
		level3.setBounds(403, 4, 84, 29);
		contentPane.add(level3);
		level3.setOpaque(true);
		
		
		
		valide = new JButton("Corrigez");
		valide.setBounds(143, 547, 115, 29);
		contentPane.add(valide);
		
		
		valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!quiz.get(count).getIsQuestion_been_answered()) {
            		if(quiz.get(count).checkAnswer(getSelectedAnswer(quiz.get(count).getRight()))) {
                		
                		soundSystem.playingSoundStop();
                		try {
							soundSystem.CorrectSoundStart();
							score +=20;
							pointsTextView.setText("Points: " + String.valueOf(score) + "/ 100");
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		//JOptionPane.showMessageDialog(valide,"Your answer is correct");
                	}else {
                	
                		soundSystem.playingSoundStop();
                		try {
							soundSystem.FalseSoundStart();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		//JOptionPane.showMessageDialog(valide,"Your answer is false");
                	}
            	}
            	
            	
            }

			
        });
		next = new JButton("Suivant");
		next.setBounds(314, 547, 115, 29);
		contentPane.add(next);
		next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	try {
					check_level();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	response1.setForeground(Color.black);
            	response2.setForeground(Color.black);
            	response3.setForeground(Color.black);
            }

			
        });
		generate_question();
		
		
		
	}
	
	public void generate_question() {
		if(!timer.isRunning()) {
			timer.start();
		}
		soundSystem.playingSoundStart();
		if(count >= quiz.size()) {
			JOptionPane.showMessageDialog(this,"no more questions");
        	
		}else {
			if(quiz.get(count).getNiveau() == 1) {
				level1.setBackground(Color.yellow);
				level2.setBackground(Color.gray);
				level3.setBackground(Color.gray);
			}
			if(quiz.get(count).getNiveau() == 2) {
				level1.setBackground(Color.yellow);
				level2.setBackground(Color.ORANGE);
				level3.setBackground(Color.gray);
			}
			if(quiz.get(count).getNiveau() == 3) {
				level1.setBackground(Color.yellow);
				level2.setBackground(Color.ORANGE);
				level3.setBackground(Color.green);
			}
			questionView.setText(quiz.get(count).getQestion());
			response1.setText(quiz.get(count).getResponse1());
			response2.setText(quiz.get(count).getResponse2());
			if(quiz.get(count).getResponse3() != null) {
				response3.setVisible(true);
				response3.setText(quiz.get(count).getResponse3());
			} else {
				response3.setVisible(false);
			}
			
			
		}
		
	}
	private void check_level() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		if(count == 4) {
			if(player.isPlayerWinLevel1()) {
				count++;
	        	generate_question();
			} 
			else if(score >=40) {
				score = 0;
				pointsTextView.setText("Points: " + String.valueOf(score) + "/ 100");
				player.setPlayerWinLevel1(true);
				soundSystem.ClappingSoundStart();
				//timer.stop();
				JOptionPane.showMessageDialog(this,"Félicitations, vous avez réussi au premier niveau!");
			}
			else {
				JOptionPane.showMessageDialog(this,"Le score minimal pour réussir le premier niveau et passer au second niveau est de 40/100 !");
			}
			
		}else if(count == 9) {
			if(player.isPlayerWinLevel2()) {
				count++;
	        	generate_question();
			} 
			else if(score >=40) {
				score = 0;
				pointsTextView.setText("Points: " + String.valueOf(score) + "/ 100");
				player.setPlayerWinLevel2(true);
				soundSystem.ClappingSoundStart();
				//timer.stop();
				
				JOptionPane.showMessageDialog(this,"Féicitations, vous avez réussi au deuxième niveau!");
			}
			else {
				JOptionPane.showMessageDialog(this,"Le score minimal necessaire pour valider le deuxième niveau et passer au troisième niveau est de 60/100 !");
			}
			
			
		}else if(count == 14) {
			 if(score >=40) {
				score = 0;
				pointsTextView.setText("Points: " + String.valueOf(score) + "/ 100");
				player.setPlayerWinLevel3(true);
				soundSystem.ClappingSoundStart();
				timer.stop();
				valide.setEnabled(false);
				next.setEnabled(false);
				JOptionPane.showMessageDialog(this,"Félicitations, vous avez réussi et fini le test!");
			}
			else {
				valide.setEnabled(false);
				next.setEnabled(false);
				JOptionPane.showMessageDialog(this,"Le score minimal nécessaire pour pour réussir le quiz est de 80/100 !");
			}
			
			
		}else {
			count++;
        	generate_question();
		}
	}

	public void temp_db() {
		//les questions de N 1
		quiz.add(new Question("JAVA est un langage","Compilé","Interprété","Compilé et interpreté",3,1));
		quiz.add(new Question("Toutes les classes héritent de la classe","Main","Object","AWT",2,1));
		quiz.add(new Question("Par convention une classe","est en minuscule","commence par une majuscule","est en majuscules",2,1));
		quiz.add(new Question("Est-ce que on peut avoir plusieurs constructeurs pour la meme classe" ,"oui","non",1,1));
		quiz.add(new Question("Dans la ligne \"public class A implements B\", B est :","Interfacce","Classe parent","Package",1,1));
		//les Questions de N 2
		quiz.add(new Question("Après la compilation, un programme écrit en\r\n" + 
				"JAVA, il se transforme en programme en bytecode\r\n" + 
				"Quelle est l'extension du programme en\r\n" + 
				"bytecode ?\r\n","a) aucun des choix","b).JAVA","c).Class",3,2));
		
		quiz.add(new Question("Class Test{\r\n" + 
				"Public Test () {\r\n" + 
				"System.out.println(Bonjour);}\r\n" + 
				"public Test (int i) {\r\n" + 
				"this();\r\n" + 
				"System.out.println(Nous sommes en +i+ �!�);};\r\n" + 
				"}\r\n" + 
				"qu’affichera l’instruction suivante? \r\n" + 
				"Test t1=new Test (2020);","a) aucun des choix","b) Bonjour Nous sommes en 2020 !","c) Nous sommes en 2020 !",3,2));
		quiz.add(new Question("Voici un constructeur de la classe Employee, y-at'il un probleme ?\r\n" + 
				"Public void Employe(String n){\r\n" + 
				"Nom=n;}\r\n" + 
				"","a)vrai","b)faux",2,2));
		quiz.add(new Question("Pour spécifier que la variable ne pourra plus être\r\n" + 
				"modifiée et doit être initialisée dès sa déclaration,\r\n" + 
				"on la déclare comme une constante avec le mot\r\n" + 
				"réservé","a) aucun des choix","b)final","c)const",2,2));
		quiz.add(new Question("Dans une classe, on accède à ses variables grâce au mot clé","a) aucun des choix","b)this","c)super",2,2));
		//les Questions de N 3
		quiz.add(new Question("calculerSalaire(int)\r\n" + 
				"calculerSalaire(int, double)\r\n" + 
				"La méthode calculerSalaire est :","a) aucun des choix","b)surchargée","c)redefinie",2,3));
		quiz.add(new Question("Une classe qui contient au moins une méthode\r\n" + 
				"abstraite doit être déclarée abstraite.","a)vrai","b)faux",1,3));
		quiz.add(new Question("Est-ce qu’une classe peut implémenter plusieurs\r\n" + 
				"interfaces ?","a)vrai","b)faux", 1,3));
		quiz.add(new Question("La déclaration d'une méthode suivante : public void traitement() throws IOException précise que la méthhode propage une exception contrôlée","a)vrai","b)faux",1,3));
		quiz.add(new Question("class Test{\r\n" + 
				"public static void main (String[] args) {\r\n" + 
				"try {\r\n" + 
				"int a =10;\r\n" + 
				"System.out.println (\"a = \" + a );\r\n" + 
				"int b = 0 / a;\r\n" + 
				"System.out.println (\"b = \" + b);\r\n" + 
				"}\r\n" + 
				"catch(ArithmeticException e)\r\n" + 
				"{System.out.println (\"diviser par 0!\"); }\r\n" + 
				"finally\r\n" + 
				"{System.out.println (\"je suis à l’intérieur de\r\n" + 
				"finally\");}}}","a) aucun des choix","b) a=10 b=0 Je suis à l’intérieur de finally","c) a=10 b=0 diviser par 0! je suis à l’intérieur de finally",1,3));
		
	}
	public int getSelectedAnswer(int right_answer) {
		ArrayList<AbstractButton> arl = Collections.list(buttonGroup.getElements());
		int user_answer = 0;
		for (AbstractButton ab : arl) {
		    JRadioButton jrb = (JRadioButton) ab;
		    if (jrb.isSelected()) {
		        user_answer =  Integer.parseInt(jrb.getName());
		    }
		    if(Integer.parseInt(jrb.getName()) == right_answer) {
		    	jrb.setForeground(Color.GREEN);
		    	
		    }else {
		    	jrb.setForeground(Color.RED);
		    	
		    }
		}
		quiz.get(count).setQuestion_been_answered(true);
		return user_answer;
	}
	public void startTimer() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	            int sec = left_time % 60;
	            int min = (left_time / 60)%60;
				countDownTextView.setText(String.format("%d:%02d", min, sec));
				if(left_time == 0) {
					try {
						finishTheGame();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				left_time--;
				
				
				
			}

			private void finishTheGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				// TODO Auto-generated method stub
				soundSystem.playingSoundStop();
				timer.stop();
				valide.setEnabled(false);
				next.setEnabled(false);
				soundSystem.FinishSoundStart();
				JOptionPane.showMessageDialog(valide,"le temps est coulé");
				
			}
		});
		timer.start();
		
	}
}
