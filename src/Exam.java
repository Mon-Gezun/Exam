import java.util.*;

public class Exam {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Exam addQuestion = new Exam();
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < 8) {
            set.add(randNum.nextInt(8)+1);
        }

        for(int i : set){
            switch(i){
                case 1:
                    addQuestion.questionOne(i);
                    break;
                case 2:
                    addQuestion.questionTwo(i);
                    break;
                case 3:
                    addQuestion.questionThree(i);
                    break;
                case 4:
                    addQuestion.questionFour(i);
                    break;
                case 5:
                    addQuestion.questionFive(i);
                    break;
                case 6:
                    addQuestion.questionSix(i);
                    break;
                case 7:
                    addQuestion.questionSeven(i);
                    break;
                case 8:
                    addQuestion.questionEight(i);
                    break;
            }
        }
        addQuestion.result();
    }

    public void questionOne(int i){

        System.out.println("1. You went to a party last night and when you arrived to school the next day, everybody is\n" +
                "talking about something you didn’t do. What will you do?");
        System.out.println("   a. Avoid everything and go with your friends");
        System.out.println("   b. Go and talk with the person that started the rumors");
        System.out.println("   c. Go and talk with the teacher");
        validatesInput(i);
    }

    public void questionTwo(int i){

        System.out.println("2. What quality do you excel the most?");
        System.out.println("   a. Empathy");
        System.out.println("   b. Curiosity");
        System.out.println("   c. Perseverance");
        validatesInput(i);
    }

    public void questionThree(int i){

        System.out.println("3. You are walking down the street when you see an old lady trying to cross, what will you do?");
        System.out.println("   a. Go and help her");
        System.out.println("   b. Go for a policeman and ask him to help");
        System.out.println("   c. Keep walking ahead");
        validatesInput(i);

    }
    public void questionFour(int i){

        System.out.println("4. You had a very difficult day at school, you will maintain a ____ attitude");
        System.out.println("   a. Depends on the situation");
        System.out.println("   b. Positive");
        System.out.println("   c. Negative");
        validatesInput(i);

    }
    public void questionFive(int i){

        System.out.println("5. You are at a party and a friend of yours comes over and offers you a drink, what do you do?");
        System.out.println("   a. Say no thanks");
        System.out.println("   b. Drink it until it is finished");
        System.out.println("   c. Ignore him and get angry at him");
        validatesInput(i);

    }
    public void questionSix(int i){

        System.out.println("6. You just started in a new school, you will...");
        System.out.println("   a. Go and talk with the person next to you");
        System.out.println("   b. Wait until someone comes over you");
        System.out.println("   c. Not talk to anyone");
        validatesInput(i);

    }
    public void questionSeven(int i){

        System.out.println("7. In a typical Friday, you would like to..");
        System.out.println("   a. Go out with your close friends to eat");
        System.out.println("   b. Go to a social club and meet more people");
        System.out.println("   c. Invite one of your friends to your house");
        validatesInput(i);

    }
    public void questionEight(int i){

        System.out.println("8. Your relationship with your parents is..");
        System.out.println("   a. I like both equally");
        System.out.println("   b. I like both equally");
        System.out.println("   c. I like my Mom the most");
        validatesInput(i);

    }

    public void validatesInput(int i){
        String ans;

        while(true){
            ans = sc.nextLine();
            if((ans.equals("a"))||(ans.equals("b"))||(ans.equals("c"))){
                map.put(i,ans);
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
    }

    public void result(){
        //function calls
        showAnswerEachQuestion();
        countAnswers();
    }
    public void showAnswerEachQuestion(){
        //print all the answers
        for(Integer i : map.keySet()){
            System.out.println("Question# "+ i + ", Answer: "+ map.get(i));
        }
    }
    public void countAnswers(){
        HashMap<String, Integer> score = new HashMap<>();
        int aTotal = 0;
        int bTotal = 0;
        int cTotal = 0;

        //total each choice was answered
        for(String i : map.values()){

            if(i.equals("a")){
                aTotal += 1;
                score.put(i, aTotal);
            }else if(i.equals("b")){
                bTotal += 1;
                score.put(i, bTotal);
            }else if(i.equals("c")){
                cTotal += 1;
                score.put(i, cTotal);
            }
        }

        //print tallies of the answers
        for (String j : score.keySet()) {
            System.out.println("count("+ j +"): " + score.get(j));
        }
        System.out.println("Total Answers: "+map.size()+"\n");

        displayResultBasedOnAnswers(aTotal, bTotal, cTotal);


    }
    public void displayResultBasedOnAnswers(int a, int b, int c){

        String Result1 = "Self-Management You manage yourself well; You take responsibility for your own behavior\n" +
                "and well-being.";
        String Result2 = "Empathy You are emphatic. You see yourself in someone else’s situation before doing\n" +
                "decisions. You tend to listen to other’s voices.";
        String Result3 = "Self-Awareness You are conscious of your own character, feelings, motives, and desires.\n" +
                "The process can be painful but it leads to greater self-awareness.";

        if((a>b) && (a>c)){
            System.out.println(Result2);
        }else if((b>a) && (b>c)){
            System.out.println(Result3);
        }else if((c>a) && (c>b)){
            System.out.println(Result1);
        }else if(a==b){
            System.out.println(Result3);
        }else if(a==c){
            System.out.println(Result2);
        }else if(b==c){
            System.out.println(Result1);
        }
    }
}
