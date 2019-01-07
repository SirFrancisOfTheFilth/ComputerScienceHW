import java.util.*;

public class SSearch {
    String[] namesArray;

    public boolean NBA(String aString, String[] namesArray){
        for(int i = 0; i < namesArray.length; i++){
          if(namesArray[i].equals(aString)){
            return true;
          }
        }
        return false;
    }

        public void selectionSort(int[] array){
          
          for(int i = 0; i < array.length; i++){
              int num = i;
              int otherVal = array[i];
            for(int j = i + 1; j < array.length; j++){
              
              if( array[j] < otherVal ){
                  num = j;
                  otherVal = array[j];
              }
            }
            array[num] = array[i];
            array[i] = otherVal;
            
            
          }
        }

    public SSearch(){
        /*
        String names  = "Micheal Ray Richardson,Derek Smith,Calvin Natt,Kareem Abdul-Jabbar,Larry Bird,Darrell Griffith,Sleepy Floyd,Mark Aguirre,Magic Johnson,Dominique Wilkins,Tom McMillen,Michael Jordan,World B. Free,Isiah Thomas,Terry Cummings,Orlando Woolridge,Jack Sikma,Bernard King,Moses Malone,Alex English,Larry Nance,Herb Williams,Charles Barkley,Adrian Dantley,Sidney Moncrief,Clyde Drexler,Alvin Robertson,Jeff Ruland,Patrick Ewing,Buck Williams,Julius Erving,Larry Smith,Karl Malone,Fat Lever,Otis Thorpe,Tom Chambers,Hot Rod Williams,Robert Parish,Harold Pressley,Bobby Hansen,Roy Tarpley,John Stockton,Byron Scott,Xavier McDaniel,Kevin Johnson,Chuck Person,Hakeem Olajuwon,Ron Harper,Chris Mullin,Dale Ellis,Michael Adams,David Robinson,Rony Seikaly,Tim Hardaway,Terry Teagle,Vern Fleming,Scott Skiles,Mitch Richmond,Kenny Smith,Dennis Scott,Gerald Wilkins,Reggie Miller,Lionel Simmons,Ricky Pierce,Reggie Lewis,Mookie Blaylock,Mark Jackson,Larry Johnson,Joe Dumars,Danny Manning,Nick Anderson,Scottie Pippen,Pervis Ellison,Dennis Rodman,Jeff Malone,Kevin Willis,Brad Daugherty,Alonzo Mourning,Dikembe Mutombo,Rumeal Robinson,Shawn Kemp,Sean Elliott,Drazen Petrovic,Shaquille O'Neal,Kenny Anderson,Chris Webber,Oliver Miller,Glen Rice,Vlade Divac,Jason Kidd,Rik Smits,Rod Strickland,Gary Payton,Cedric Ceballos,Jamal Mashburn,Penny Hardaway,Elliot Perry,Juwan Howard,Arvydas Sabonis,Chris Gatling,Grant Hill,Armen Gilliam,Cliff Robinson,Terrell Brandon,Allen Iverson,Loy Vaught,Glenn Robinson,Terry Mills,Sam Cassell,Tim Duncan,Jayson Williams,Steve Smith,Wesley Person,Kevin Garnett,Darrell Armstrong,Vince Carter,Antonio McDyess,Stephon Marbury,Kobe Bryant,Jalen Rose,Michael Finley,Steve Francis,Ray Allen,Paul Pierce,Cuttino Mobley,Derek Anderson,Shawn Marion,Aaron McKie,Baron Davis,Ben Wallace,Tracy McGrady,Kurt Thomas,Rasheed Wallace,Andre Miller,Dirk Nowitzki,Eddie Jones,Jermaine O'Neal,Richard Hamilton,Steve Nash,Elton Brand,Shareef Abdur-Rahim,Richard Jefferson,Peja Stojakovic,Allan Houston,Chauncey Billups,Antoine Walker,Lucious Harris,Metta World Peace,Rashard Lewis,Jerry Stackhouse,Jamaal Magloire,Carmelo Anthony,Zydrunas Ilgauskas,Lamar Odom,Yao Ming,Andrei Kirilenko,Dwyane Wade,Kenyon Martin,Carlos Boozer,Voshon Lenard,Quentin Richardson,Jason Richardson,Marcus Camby,Mike Bibby,Brad Miller,LeBron James,Jason Terry,Larry Hughes,Chris Bosh,Bruce Bowen,Pau Gasol,Amar'e Stoudemire,Gilbert Arenas,Ben Gordon,Jamal Crawford,Chris Wilcox,Tony Parker,Chris Paul,Mike James,Joe Johnson,Gerald Wallace,T.J. Ford,Manu Ginobili,Al Jefferson,Kevin Martin,Mehmet Okur,Caron Butler,Michael Redd,Josh Howard,Mo Williams,Dwight Howard,Antawn Jamison,Hedo Turkoglu,Brandon Roy,Josh Smith,Stephen Jackson,Danny Granger,Deron Williams,Devin Harris,David West,David Lee,Andrew Bynum,Jameer Nelson,Rodney Stuckey,Al Harrington,Kevin Durant,Andrew Bogut,Russell Westbrook,Chris Kaman,Derrick Rose,Brandon Jennings,Zach Randolph,Kyle Lowry,LaMarcus Aldridge,Monta Ellis,Rajon Rondo,Goran Dragic,Drew Gooden,Ersan Ilyasova,Ty Lawson,Jeremy Lin,Marc Gasol,Nikola Pekovic,J.R. Smith,James Harden,John Wall,Nate Robinson,Kyrie Irving,Greivis Vasquez,Paul George,Blake Griffin,Al Horford,Kenneth Faried,Jeff Teague,Nikola Vucevic,Kemba Walker,Kevin Love,Jared Sullinger,Paul Millsap,DeMarcus Cousins,Thaddeus Young,Jordan Crawford,Markieff Morris,Michael Carter-Williams,Isaiah Thomas,Brook Lopez,Stephen Curry,Anthony Davis,Damian Lillard,Giannis Antetokounmpo,Klay Thompson,Jimmy Butler,Lou Williams,Karl-Anthony Towns,J.J. Barea,Kawhi Leonard,Draymond Green,Marcin Gortat,Reggie Jackson,DeMar DeRozan,Nicolas Batum,Andre Drummond,Hassan Whiteside,Dion Waiters,Joel Embiid,Gordon Hayward,George Hill,Ben Simmons,Nikola Jokic,Victor Oladipo,Khris Middleton,Bradley Beal,Tobias Harris,Kristaps Porzingis,Pascal Siakam,C.J. McCollum";
        namesArray = names.split(",");
        System.out.println(namesArray.length);
        
        if(NBA("Stephen Curry", namesArray)){
          System.out.println("true");
        } else {
          System.out.println("false");
        }
        */
        
        int[] theInts = new int[10];
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int counter = 0;
            for(int i = 1; i <= 1000; i++){
              for(int j = 1; j <= i; j++){
                if(i % j == 0){
                  counter += 1;
                }
              }

              if(counter == 2){
                //System.out.println(i);
                primes.add(i);
                counter -= counter;
              } else {
                counter -= counter;
              }

           }
           
           
           for(int i = 0; i < 10; i++){
               theInts[i] = primes.get((int)(Math.random() * primes.size()));
            }
            
            for(int i = 0; i < 10; i++){
                System.out.println(theInts[i]);
            }
            
            selectionSort(theInts);
            System.out.println("-----------------------------------------");
            
            for(int i = 0; i < 10; i++){
                System.out.println(theInts[i]);
            }
            
    

    }

}
