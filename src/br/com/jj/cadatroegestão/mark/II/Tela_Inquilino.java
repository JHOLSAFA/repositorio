package br.com.jj.cadatroegestão.mark.II;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ietf.jgss.Oid;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.mysql.cj.xdevapi.Result;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tela_Inquilino extends JFrame {

	private JPanel contentPane;
	private JTextField TfNome;
	private JTextField TfIdade;
	private JTextField TfSexo;
	private JTextField TfTelefone;
	private JTextField TfEmail;
	private JButton BUTOM_BUSCAR;
	private JTextField TfBuscar;
	private JScrollPane scrollPane;
	private JTable tabledados;
	private JButton btnListaDeDados;
	private JTextField Tfid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inquilino frame = new Tela_Inquilino();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Inquilino() {
		setTitle("Cadastro-Inquilino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 11, 53, 19);
		contentPane.add(lblNewLabel);

		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setForeground(Color.BLACK);
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(120, 58, 35, 19);
		contentPane.add(lblSexo);

		JLabel lblIdade = new JLabel("IDADE");
		lblIdade.setForeground(Color.BLACK);
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdade.setBounds(24, 58, 69, 19);
		contentPane.add(lblIdade);

		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(216, 58, 69, 19);
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(24, 92, 35, 19);
		contentPane.add(lblEmail);

		TfNome = new JTextField();
		TfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		TfNome.setBounds(24, 27, 543, 20);
		contentPane.add(TfNome);
		TfNome.setColumns(12);

		TfIdade = new JTextField();
		TfIdade.setFont(new Font("Arial", Font.PLAIN, 12));
		TfIdade.setColumns(12);
		TfIdade.setBounds(24, 75, 86, 20);
		contentPane.add(TfIdade);

		TfSexo = new JTextField();
		TfSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		TfSexo.setColumns(12);
		TfSexo.setBounds(120, 75, 86, 20);
		contentPane.add(TfSexo);

		TfTelefone = new JTextField();
		TfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		TfTelefone.setColumns(12);
		TfTelefone.setBounds(216, 77, 86, 20);
		contentPane.add(TfTelefone);

		TfEmail = new JTextField();
		TfEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		TfEmail.setColumns(12);
		TfEmail.setBounds(24, 110, 543, 20);
		contentPane.add(TfEmail);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 171, 557, 293);
		contentPane.add(panel);
		panel.setLayout(null);

		BUTOM_BUSCAR = new JButton("ABRIR");
		BUTOM_BUSCAR.setBackground(Color.DARK_GRAY);
		BUTOM_BUSCAR.setFont(new Font("Arial", Font.PLAIN, 12));
		BUTOM_BUSCAR.setForeground(Color.GREEN);
		BUTOM_BUSCAR.setBounds(10, 21, 111, 23);
		panel.add(BUTOM_BUSCAR);

		TfBuscar = new JTextField();
		TfBuscar.setBounds(130, 22, 407, 20);
		panel.add(TfBuscar);
		TfBuscar.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 537, 193);
		panel.add(scrollPane);
		
		tabledados = new JTable();
		tabledados.setColumnSelectionAllowed(true);
		tabledados.setCellSelectionEnabled(true);
		tabledados.setRowSelectionAllowed(false);
		tabledados.setEnabled(false);
		tabledados.setForeground(Color.YELLOW);
		tabledados.setBackground(Color.DARK_GRAY);
		tabledados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", "", null, null, null},
			},
			new String[] {
				"ID", "NOME", "IDADE", "SEXO", "TELEFONE", "EMAIL"
			}
		));
		tabledados.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabledados.getColumnModel().getColumn(1).setPreferredWidth(220);
		tabledados.getColumnModel().getColumn(2).setPreferredWidth(56);
		tabledados.getColumnModel().getColumn(3).setResizable(false);
		tabledados.getColumnModel().getColumn(5).setPreferredWidth(202);
		scrollPane.setViewportView(tabledados);
		
		btnListaDeDados = new JButton("LISTAR DADOS");
		btnListaDeDados.setBounds(10, 55, 111, 23);
		panel.add(btnListaDeDados);
		btnListaDeDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = Conexao.faz_conexao();
					String sql = " SELECT *FROM dados_inquilinos";
					PreparedStatement sttm =con.prepareStatement(sql);
					
					ResultSet rs= sttm.executeQuery();
					DefaultTableModel modelo = (DefaultTableModel) tabledados.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
						modelo.addRow(new Object [] {rs.getString("id"), rs.getString("Nome"), rs.getString("Idade"),rs.getString("Sexo"), rs.getString("Telefone"), rs.getString("Email") });
						
					}
					
					rs.close();
					con.close();
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnListaDeDados.setBackground(Color.DARK_GRAY);
		btnListaDeDados.setForeground(Color.GREEN);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "informe o id");
				}else {
				
				
				try {
					
					Connection con = Conexao.faz_conexao();
					String sql ="UPDATE dados_inquilinos SET Nome=?, SET Idade=?, SET Sexo=?, SET Telefone=?, SET Email=? WHERE id=?";
					PreparedStatement sttm= con.prepareStatement(sql);
					
					sttm.setString(1, TfNome.getText());
					sttm.setString(2, TfIdade.getText());
					sttm.setString(3, TfSexo.getText());
					sttm.setString(4, TfTelefone.getText());
					sttm.setString(5, TfEmail.getText());
					
					sttm.execute();
					sttm.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO");
					
					
					
				} catch (Exception e1) {
					// TODO: handle exception
				}}
			}
			
	
		});
		btnAtualizar.setForeground(Color.GREEN);
		btnAtualizar.setBackground(Color.DARK_GRAY);
		btnAtualizar.setBounds(140, 55, 111, 23);
		panel.add(btnAtualizar);
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SELECIONE UM ID ");
				}else {
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql ="DELETE fron dados_inquilinos WHERE id=?";
					PreparedStatement sttm = con.prepareStatement(sql);
					
					sttm.setString(1, Tfid.getText());
					sttm.execute();
					sttm.close();
					con.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}}
				
				
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(263, 55, 89, 23);
		panel.add(btnNewButton);
		
				JButton ButtonCadastro = new JButton("CADASTRAR");
				ButtonCadastro.setBounds(24, 141, 111, 23);
				contentPane.add(ButtonCadastro);
				ButtonCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
				ButtonCadastro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(TfNome.getText().equals("")|| TfIdade.getText().equals("")|| TfSexo.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "FALTANDO INFORMAÇÕES.");
						}else {

						try {
							Connection con = Conexao.faz_conexao();
							String sql = "insert into dados_inquilinos (Nome, Idade, Sexo, Telefone, Email) value (?,?,?,?,?)";
							PreparedStatement sttm = con.prepareStatement(sql);

							sttm.setString(1, TfNome.getText());
							sttm.setString(2, TfIdade.getText());
							sttm.setString(3, TfSexo.getText());
							sttm.setString(4, TfTelefone.getText());
							sttm.setString(5, TfEmail.getText());

							sttm.execute();

							sttm.close();
							con.close();

							// JOptionPane.showConfirmDialog(null, "TUDO CERTO?");
							JOptionPane.showMessageDialog(null, "cadastrado com sucesso");

							TfNome.setText("");
							TfIdade.setText("");
							TfSexo.setText("");
							TfTelefone.setText("");
							TfEmail.setText("");

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}}
				});
				ButtonCadastro.setBackground(Color.DARK_GRAY);
				ButtonCadastro.setForeground(Color.RED);
				
				Tfid = new JTextField();
				Tfid.setBounds(334, 75, 26, 20);
				contentPane.add(Tfid);
				Tfid.setEditable(false);
				Tfid.setColumns(10);
				
				JLabel id = new JLabel("id");
				id.setHorizontalAlignment(SwingConstants.CENTER);
				id.setBounds(334, 60, 26, 14);
				contentPane.add(id);
		BUTOM_BUSCAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TfBuscar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "informe a busca");
				}else {

				try {

					Connection con = Conexao.faz_conexao();
					String sql = " SELECT *FROM dados_inquilinos where id like ?";
					PreparedStatement sttm = con.prepareStatement(sql);
					
					sttm.setString(1, "%"+ TfBuscar.getText());
					//sttm.setString(2, "%"+TfBuscar.getText());

					ResultSet rs = sttm.executeQuery();
					
					while (rs.next()) {
						TfNome.setText(rs.getString("Nome"));
						TfIdade.setText(rs.getString("Idade"));
						TfSexo.setText(rs.getString("Sexo"));
						TfTelefone.setText(rs.getString("Telefone"));
						TfEmail.setText(rs.getString("Email"));
						Tfid.setText(rs.getString("id"));
					}
					
					rs.close();
					con.close();
					sttm.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}}

			}

		});

	}
}
