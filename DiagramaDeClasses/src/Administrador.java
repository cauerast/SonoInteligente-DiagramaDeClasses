import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador implements Autenticacao{
    private int ID;
    private String nome, email, senha;
    private ArrayList<Paciente> pacientes;
    private boolean isLogged;

    public Administrador() {
        this.pacientes = new ArrayList<>();
        this.isLogged = false;
    }

    public Administrador(int ID, String nome, String email, String senha) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pacientes = new ArrayList<>();
        this.isLogged = false;
    }

    public void setID(int ID) {
        this.ID = this.ID;
    }

    public void setNome(String nome) {
        this.nome = this.nome;
    }

    public void setEmail(String email) {
        this.email = this.email;
    }

    public void setSenha(String senha) {
        this.senha = this.senha;
    }

    public int getID() {
        return this.ID;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public ArrayList getPacientes() {
        return this.pacientes;
    }

    @Override
    public String toString() {
        return "\n\tAdministrador {" +
                "\nID: " + this.ID +
                "\nNome: " + this.nome +
                "\nEmail: " + this.email +
                "\nSenha: " + this.senha +
                "\nPacientes: " + this.pacientes +
                '}';
    }

    @Override
    public void login(String email, String senha){
        if(email.equals("administrador@gmail.com") && senha.equals("SI1235")){
            this.isLogged = true;
            System.out.println("Logado como administrador na Sono Inteligente...");
        } else {
            System.out.println("Email ou senha incorretos!");
        }
    }

    @Override
    public void logout(){
        this.isLogged = false;
        System.out.println("Saindo da conta...");
    }

    public void cadastrarPaciente(int ID, String nome, String CPF, String cidade, String telefone, LocalDate dataNasc){
        this.pacientes.add(new Paciente(ID, nome, CPF, cidade, telefone, dataNasc));
    }

    public Paciente getPaciente(int ID){
        for(Paciente p : this.pacientes){
            if(p.getID() == ID){
                return p;
            }
        }
        return null;
    }
}
