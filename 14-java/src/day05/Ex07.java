package day05;

class person {
        String name;
        int age;
        public person(String name, int age) {
            this.name = name;
            this.age = age;

        }
        static void main() {
            person p1 = new person("Michael Jackson", 24);
            person p2 = new person("Mariah Carey", 21);
            person p3 = new person("James Dean", 36);

            System.out.printf("Name : %s Age : %d\n", p1.name, p1.age);
            System.out.printf("Name : %s Age : %d\n", p2.name, p2.age);
            System.out.printf("Name : %s Age : %d\n", p3.name, p3.age);
        }
}
