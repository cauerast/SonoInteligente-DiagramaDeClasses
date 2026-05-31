package dc.unifacef.sonoInteligenteSpring.Model;

public interface Autenticacao {
    public void login(String nome, String senha);
    public void logout();
}
