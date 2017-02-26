//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014
public interface Directory{
	void insertNew(String name);
	void delete(String name, String num);
	String lookUp(String surname);
	void changeNum(String surname, String newNumber );
	void printDirectory();
}
