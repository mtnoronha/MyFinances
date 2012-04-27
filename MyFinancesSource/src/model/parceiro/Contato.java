
package model.parceiro;


public class Contato {
    private int id;
    private String nome,email,skype,msn,fax,tel1,tel2,tel3,cel,ramal1,ramal2,ramal3;

    public Contato(String nome, String email, String skype, String msn, String fax, String tel1, String tel2, String tel3, String cel, String ramal1, String ramal2, String ramal3) {
        this.nome = nome;
        this.email = email;
        this.skype = skype;
        this.msn = msn;
        this.fax = fax;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
        this.cel = cel;
        this.ramal1 = ramal1;
        this.ramal2 = ramal2;
        this.ramal3 = ramal3;
    }

    public String getRamal1() {
        return ramal1;
    }

    public void setRamal1(String ramal1) {
        this.ramal1 = ramal1;
    }

    public String getRamal2() {
        return ramal2;
    }

    public void setRamal2(String ramal2) {
        this.ramal2 = ramal2;
    }

    public String getRamal3() {
        return ramal3;
    }

    public void setRamal3(String ramal3) {
        this.ramal3 = ramal3;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }
    
    


    
}
