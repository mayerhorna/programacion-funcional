package com.curso.java_avanzado_pruebas;

class EnvioEmail{
	//REGULAR INNER CLASS
	class EmailValidator{
		private String patronEmail;
		public void setPatronEmail(String patronEmail) {
			this.patronEmail = patronEmail;
		}
		public String getPatronEmail() {
			return patronEmail;
		}
		public EmailValidator() {
		}
	}
	
	//STATIC NESTED CLASS
	static class EmailParser{
		private String patronParser;
		public void setPatronParser(String patronParser) {
			this.patronParser = patronParser;
		}
		public String getPatronParser() {
			return patronParser;
		}
	}
}



public class ClasesInternasEnJava {

	public static void main(String[] args) {
		//Method – Local  Inner Classes
		class EmailProcessor{
			private String patronProcessor;
			public void setPatronProcessor(String patronProcessor) {
				this.patronProcessor = patronProcessor;
			}
			public String getPatronProcessor() {
				return patronProcessor;
			}
		}
		
		//creacion de objeto de clase interna regular
		EnvioEmail emaEnvioEmail = new EnvioEmail();
		EnvioEmail.EmailValidator emailValidator = emaEnvioEmail. new EmailValidator();
		emailValidator.setPatronEmail("%");
		System.out.println(emailValidator.getPatronEmail());
		
		//creacion de objeto de clase interna statica
		EnvioEmail.EmailParser emailParser = new EnvioEmail.EmailParser();
		emailParser.setPatronParser("$");
		System.out.println(emailParser.getPatronParser());
		
		//creacion de objeto de clase interna a un metodo
		EmailProcessor emailProcessor = new EmailProcessor();
		emailProcessor.patronProcessor = "$$";
		System.out.println(emailProcessor.getPatronProcessor());
		
	}
	
 

}
