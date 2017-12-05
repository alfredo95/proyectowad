package actionsupportpackage;

import com.opensymphony.xwork2.ActionSupport;
import entity.Login;
import entity.HibernateUtil;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginActionSupport extends ActionSupport implements SessionAware{
 String userName,password;
 Session hibernateSession;
 Login login;
 private SessionMap<String, Object> sessionMap;
 
 public String execute() throws Exception {
 hibernateSession=HibernateUtil.getSessionFactory().openSession(); 
 Transaction t1=hibernateSession.beginTransaction();
 login=(Login) hibernateSession.createQuery("from Login where userName='"+userName+"'AND password='"+password+"'").uniqueResult();
 t1.commit();
 
 if(userName!=null && password!=null &&(!userName.equals(""))&&(!password.equals("")))
 {
  if(login!=null)
  {
      sessionMap.put("userName",userName);
      if(login.getTipo().equals("1")){          
          return "alumno";
      }
      if(login.getTipo().equals("2")){
          return "maestro";
      }
      if(login.getTipo().equals("3")){
          return "administrador";
      }
  }
  //return SUCCESS; 
 }

 addActionError("User Name or password does not exist");
 return INPUT;

 }
 public String getPassword() {
 return password;
 }
 public void setPassword(String password) {
 this.password = password;
 }
 public String getUserName() {
 return userName;
 }
 public void setUserName(String userName) {
 this.userName = userName;
 }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap =(SessionMap)map;
    }
}