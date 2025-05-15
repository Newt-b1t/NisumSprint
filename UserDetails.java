    // Create a class UserDetails with variables like name,id,email,password,creditCard,creditCardbalance where in name,
    // id,email of any user should be accessible to all but not creditcard and creditcardbalance.

    public class UserDetails {
        public String name;
        public int id;
        public String email;

        private String password;
        private String creditCard;
        private double creditCardBalance;

        public UserDetails(String name, int id, String email, String password, String creditCard, double creditCardBalance) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.password = password;
            this.creditCard = creditCard;
            this.creditCardBalance = creditCardBalance;
        }

        public String getPassword() {
            return password;
        }

        public void setCreditCard(String creditCard) {
            this.creditCard = creditCard;
        }

        public String getCreditCard() {
            return creditCard;
        }

        public void setCreditCardBalance(double creditCardBalance) {
            this.creditCardBalance = creditCardBalance;
        }

        public double getCreditCardBalance() {
            return creditCardBalance;
        }

        public void displayPublicInfo() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Email: " + email);
        }
    }

