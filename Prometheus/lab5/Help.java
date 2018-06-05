package Labs_OOP.prometheus._week5;
    class Help implements Command{
        public void execute(){
            System.out.println("Help executed");
        }
    }
    class Echo implements Command{
        String str;
        public void execute(){
            System.out.println(str);
        }
    }
    class Date_now implements Command{
        public void execute(){
            System.out.println(System.currentTimeMillis());
        }
    }
    class Exit implements Command{
        public void execute(){
            System.out.println("Goodbye!");
        }
    }
