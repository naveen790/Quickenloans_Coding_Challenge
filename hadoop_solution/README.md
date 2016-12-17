#Hadoop Solution in Java  

- Question:    
Write a MapReduce program(Preferably in Java) to find common friends between two friends in a social network. Input to this program is the a person with list of their friends:    
A -> B C D  
B -> A C D E  
C -> A B D E  
D -> A B C E  
E -> B C D  
  
- Solution    
  
This program was run on the system with the following configuration:  
- Ubuntu 16.04 LTS  
- Hadoop 2.6.0  
- Java 1.8  

The ouput of the map reduce program for the above input file is  
  
A B	  are mutual/common friends with    C D  
A C	  are mutual/common friends with    B D  
A D	  are mutual/common friends with    B C  
B C	  are mutual/common friends with    A D E  
B D	  are mutual/common friends with    A C E  
B E	  are mutual/common friends with    C D  
C D	  are mutual/common friends with    A B E  
C E	  are mutual/common friends with    B D  
D E	  are mutual/common friends with    B C  
  
  
The logic of the program is:  
Mapper:  
1.) Takes in input and reads line by line  
2.) For each line it splits the line based on "->". The first part of split gives the person and the second part gives a list of friends.  
3.) For each friend in the list, combine with the person(in alphabetical order) to form the map output key and the friend list as the value for that key  
4.) Mapper output sample based on the input above:  
- key = A B  
- value = B C D  
  
Reducer:  
1.) For each key receive a value list containing friends list  
2.) Split each list and store each friend from the list in friendlist  
3.) For each friend in the list check if the friend is in the friendset  
- If friend in friendset add friend to mutualfriends string.  
- Else add friend to friendset  
4.) Reducer output sample for the input above:  
- key = A B
- value =  are mutual/common friends with    C D  

The output is read as person A and B have mutual/common friends with persons C and D
