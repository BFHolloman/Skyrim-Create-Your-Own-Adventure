package com.example.project02;

import android.view.View;

import com.example.project02.model.User;

import static com.example.project02.HomeActivity.ACTIVE_USER_KEY;


public class Story {

    GameScreen gs;
    boolean intimidateGuard = false;
    boolean bribeGuard = false;
    String nextPosition1,nextPosition2,nextPosition3;
    User user;

//   public Story(User user){
//        this.user = user;
//    }
//
//    public Story(){
//
//    }

    public void selectPosition(String position){
        switch (position){
            case "startingScene": startingScene(); break;
            case "runAway": runAway(); break;
            case "fight": fightThief();break;
            case "dead": dead();break;
            case "goTitleScreen": gs.goTitleScreen();break;
            case "scene1": scene1();break;
            case "give": giveMoney();break;
            case "goRiver" : river();break;
            case "goMountains": mountains();break;
            case "goCaravan": caravan();break;
            case "skeever": skeever();break;
            case "attackSkeever": attackSkeever();break;
            case "intimidateSkeever": intimidateSkeever();break;
            case "riften" : riften();break;
            case "man": caravanMan();break;
            case "helpMan": helpMan();break;
            case "ignoreMan": ignoreMan();break;
            case "attackGuard": attackGuard();break;
            case "bribeGuard": bribeGuard();break;
            case "intimidateGuard": intimidateGuard();break;
            case "success": success();break;
        }
    }


    public Story(GameScreen gs){
        this.gs = gs;
        System.out.println("gs"+this.gs.getIntent().getSerializableExtra(ACTIVE_USER_KEY));
        user = (User) this.gs.getIntent().getSerializableExtra(ACTIVE_USER_KEY);
    }
    public void showAllButtons(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);

    }
    public void startingScene(){
        gs.image.setImageResource(R.drawable.thieves);
        String line = "Continuing on track to Riften, you hears footsteps approaching behind you quickly. you turns around to see a Nord man wearing the recognizable 'Thieves Guild' attire. The Nord demands you to give him their money or lose their life. Who would have thought for you to run into trouble so quickly.\n\n What does you do?";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText("Run away");
        gs.button2.setText("Give Septims");
        gs.button3.setText("Fight");

        showAllButtons();
        nextPosition1 = "runAway";
        nextPosition2 = "give";
        nextPosition3 = "fight";

    }

    public void giveMoney(){
        String line = "It's not worth you 's life to try and fight this one out, you complies with the thief's demand and gives him their 50 Septims. He snatches the Septims from you's hand and laughs at you for giving up so easily, as he leaves. you is shaken, but at least they're alive.";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText("Continue");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "scene1";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void runAway(){
        String line1 =  "you tries to pull a fast one and tries to run away from the Thieves Guild member. you tries to run as fast as they can, but you cannot outrun the Nord's throwing knife. With a direct hit to their back, you falls down and the man robs you of all their gold, then leaves you for the wolves. you go into shock and die.";
        gs.text.setText(line1.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "dead";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void fightThief(){
        String line = "you takes out their small dagger in an attempt to defend themself, but alas the Nord has a higher One-Handed level than you. He easily dodges their attack and lands his stab. you falls down in shock and lose consciousness as he robs their body of all their gold. you have been left to die.";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "dead";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void dead(){
        gs.image.setImageResource(R.drawable.deathscreen);
        String line = "you is dead. Your journey to Riften ends here.\n\n GAME OVER";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText("Go to title screen");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void scene1(){
        gs.image.setImageResource(R.drawable.skyrimpaths);
        String line = "After the close encounter with the member from the Thieves Guild, you continues on their way to Riften. you encounters 3 different paths. you can cross White River (fast, but unknown what is in the water), travel through the mountain adjacent to the river(path less traveled), or take the paved path avoiding the river and the mountain (safe, but slow).";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText("river");
        gs.button2.setText("mountains");
        gs.button3.setText("paved path");

        showAllButtons();
        nextPosition1 = "goRiver";
        nextPosition2 = "goMountains";
        nextPosition3 = "goCaravan";

    }
    public void river(){
        gs.image.setImageResource(R.drawable.slaughterfish);
        String line = "you decides to take their chances and take the fastest route. you starts heading through the water hastily. you feels movement around their feet and try to move faster. you notice slaughterfish swimming around and they start to swarm, before you gets out of the water the slaughterfish all start attacking you and you is helpless.";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "dead";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void mountains(){
        gs.image.setImageResource(R.drawable.mountains);
        String line = "you takes the mountain route and the path less traveled as the adventurer you is. you gets back on pace and makes their way through, as you can see Riften's gates. you proceeds.";
        gs.text.setText(line.replace("you", user.getUserName()));

        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "skeever";
        nextPosition2 = "";
        nextPosition3 = "";
    }
    public void skeever(){
        gs.image.setImageResource(R.drawable.welp);
        String line = "you encounters a Skeever while traveling through the mountains. With dagger in hand, you wonders if it would be better to fight or try to spare the ugly rodents life by trying to scare it away.\n\n What does you do?";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText("Attack");
        gs.button2.setText("Intimidate");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "attackSkeever";
        nextPosition2 = "intimidateSkeever";
        nextPosition3 = "";
    }
    public void attackSkeever(){

        String line = "you decides to attack the Skeever, with their small dagger. It doesn't take much effort to dispose of the rodent, but it did get a bite in. you feels accomplished taking down the Skeever, but as you continues they realize that the bite wound is getting worse. you feels all their muscles and joints start to freeze and lock up painfully. you realizes they have 'Rockjoint.' you becomes unable to move and cannot continue.";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "dead";
        nextPosition2 = "";
        nextPosition3 = "";
    }
    public void intimidateSkeever(){
        intimidateGuard = true;
        String line = "you makes their body appear bigger and start trying to intimidate the Skeever away. The Skeever gets intimidated, and you's attempt was successful. you starts heading down the mountain with Riften in eye's view. \n\n**you feels powerfull**";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "riften";
        nextPosition2 = "";
        nextPosition3 = "";
    }
    public void caravan(){
        gs.image.setImageResource(R.drawable.skyrimpaths);
        String line = "you chooses to take the safest route to ensure that they get there in one piece. you tries to pick up the pace because they know that this route will take the longest. you proceeds.";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "man";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void caravanMan(){
        gs.image.setImageResource(R.drawable.wagonman);
        String line = "you makes their way on the safest path. you comes across a man whos goods have fallen out the back of his wagon. As you approaches, they think about whether if they should help the man or not because you doesn't want any more delays. \n\n What does you do?";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText("help");
        gs.button2.setText("ignore");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "helpMan";
        nextPosition2 = "ignoreMan";
        nextPosition3 = "";
    }
    public void helpMan(){
        bribeGuard = true;
        String line = "Thinking if you were in the situation they would want help, you stops and helps lift the man's goods back onto the back of the wagon. The man is very thankful and offers a ride, however he does not have the same destination. He instead gives you 35 Septims for their troubles and part ways with Riften in sight. \n\n **Septims Received**";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "riften";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void ignoreMan(){
        String line = "you has no time to waste, thus no time to help the man. you walks pass him without a glance, making a point that you have no intention in helping. you continues walking with Riften very close.";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "riften";
        nextPosition2 = "";
        nextPosition3 = "";
    }
    public void riften(){
        gs.image.setImageResource(R.drawable.riftenguard);
        String line = "you has finally arrived at Riften's gate. you 's adventure from Whiterun to Riften is complete. you walks up to the gate and a Riften guard intercepts you 's attention. The guard demands that you gives him 30 Septims or he will not let them in. What does you do?";
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText("Attack");
        gs.button2.setText("Bribe the guard");
        gs.button3.setText("Intimidate");
    showAllButtons();
        nextPosition1 = "attackGuard";
        nextPosition2 = "bribeGuard";
        nextPosition3 = "intimidateGuard";
    }
    private void bribeGuard() {
        if (bribeGuard == true){
            String line = "After getting robbed by the thieves guild crook, you thought they were screwed because the man took all you 's Septims. However, you remembers helping out the man with his wagon resulted in being given 35 Septims, which is just enough to get in. you gives the corrupted guard their money and you 's way into Riften.";
            gs.text.setText(line.replace("you", user.getUserName()));
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "success";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        if (bribeGuard == false){
            String line = "After getting robbed by the thieves guild crook, you realized they were screwed because the man took all their gold. you has no way to get into Riften with this corrupted guard at his post. At this moment in time, there is nothing that you can do...";
            gs.text.setText(line.replace("you", user.getUserName()));
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
        }
    }
    private void attackGuard() {
        String line = "YOU attacks the guard.\n\n Guard: 'You have committed a crime against Skyrim and her people. what says you in your defense?'\n\n YOU says nothing. The guard takes YOU to jail. At least YOU made it into Riften... jail." ;
        gs.text.setText(line.replace("YOU", user.getUserName()));
        gs.button1.setText(">");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "dead";
        nextPosition2 = "";
        nextPosition3 = "";
    }
    private void intimidateGuard() {

        if (intimidateGuard == true){
            String line = "you was not going to let this measly little guard with his compensating sword stop them from getting to Riften to see Balimund. you uses their exquisite speech skills, to threaten the guard to let them in. The guard cowards in fear as you's fiery glare of a thousands suns seeps into his soul. you makes his way through Riften's gates and confidently walks through the marketplace to the Scorched Hammer. ";
            gs.text.setText(line.replace("you", user.getUserName()));
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "success";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        if (intimidateGuard == false){
            String line = "you was not going to let this measly little guard with his compensating sword stop them from getting to Riften to see Balimund. you tried to intimidate the guard with their impeccable pecs. The guard just laughs and kicks you to the side with other people laughing as well. you feels defeated and cannot do anything with this corrupted guard at his post. you last obstacle to Riften must be tackled another day.";
            gs.text.setText(line.replace("you", user.getUserName()));
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
        }

    }
    public void success(){
        gs.image.setImageResource(R.drawable.balimund);
        String line = "you walks through the marketplace and hears the pounding of metal on anvil and knows that must be their friend Balimund. you follows the sound and sees Balimund working at the Scorched Hammer. you and Balimund greet each other and are both relieved that you made it safe. The two of you go out to catch up over a goblet of mead and you's journey has came to a successful end." ;
        gs.text.setText(line.replace("you", user.getUserName()));
        gs.button1.setText("End");
        gs.button2.setText("");
        gs.button3.setText("");


        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
    }

}
