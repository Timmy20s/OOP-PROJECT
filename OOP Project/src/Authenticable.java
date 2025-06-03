public  interface Authenticable{
   boolean authenticate();
   String otp();
   String password();
   String passkey();
}
