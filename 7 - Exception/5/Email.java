public class Email {
    private String email; 

    public Email(String email) {
        this.email = email;
    };
    
    public boolean validateEmail() throws InvalidEmailException, InvalidDomainException {
        /**
         * Implementasi dengan aturan:
         * Aturan email
         * - Email harus mengandung tepat 1 karakter @ ditengah email
         * - Bagian sebelum @ tidak boleh kosong
         * - Bagian email setelah @ harus memiliki tepat 1 buah titik (.)
         * - Email hanya akan mengandung huruf, angka, (@), dan (.). Karakter lain tidak
         * perlu diperiksa
         * 
         * "john@example.com" => Email Valid
         * "jane.doe@gmail.com" => Email Valid
         * "" => mengembalikan pesan "Email tidak boleh kosong"
         * "example.com" => mengembalikan pesan "Email harus mengandung tepat satu buah @"
         * "@example.com" => mengembalikan pesan "@ tidak boleh di awal email"
         * "john@com" => mengembalikan pesan "Email harus memiliki domain yang valid"
         */

        int i;
        int j = 0;
        for (i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                j++;
            }
        }

        if (email == "") {
            throw new InvalidEmailException("Email tidak boleh kosong");
        }
        if (j != 1) {
            throw new InvalidEmailException("Email harus mengandung tepat satu buah @");
        }
        if (email.charAt(0) == '@') {
            throw new InvalidEmailException("@ tidak boleh di awal email");
        }


        int at = email.indexOf("@");
        String domain = email.substring(at + 1);
        int dot = domain.indexOf(".");
        j = 0;
        for (i = 0; i < domain.length() ; i++) {
            if (domain.charAt(i) == '.') {
                j++;
            }
        }
                
        if (j != 1){
            throw new InvalidDomainException();
        } 
        if (dot == 0){
            throw new InvalidDomainException();
        }
        if (dot == domain.length() - 1) {
            throw new InvalidDomainException();
        } 
        
        return true;
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        // Implementasi InvalidEmailException
        super(message);
    }
}

class InvalidDomainException extends Exception {
    public String getMessage() {
        // Implementasi custom message InvalidDomainException
        // Return pesan multak berisi: "Email harus memiliki domain yang valid
        return ("Email harus memiliki domain yang valid");
    }
}