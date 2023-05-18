package phonebook;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		PhoneDirectory directory = new PhoneDirectory();
		directory.add(new Record("Tania", "0380966596207", 10));
		directory.add(new Record("Oleh", "0380673201273", 10));
		directory.add(new Record("Vita", "0380970023172", 10));
		directory.add(new Record("Tania", "0380663871290", 10));
		directory.add(new Record("Ivan", "0380961327897", 10));

		for(int j = 0; j < directory.getSize(); j++) {
			System.out.println(directory.get(j).name);
		}
		
		System.out.println("\n" + directory.find("Vita"));
		System.out.println("\n" + directory.findAll("Tania"));
	}
	
	static class PhoneDirectory {
		Record[] records;
		int size;
		
		PhoneDirectory() {
			this(10);
		}
		
		public PhoneDirectory(int i) {
			this.records = new Record[i];
		}

		public boolean add(Record record) {
			if(size > records.length/2) {
				expandArray();
			}
			for(int i = 0; i < records.length; i++) {
				if(i != 0 && records[i-1].name.equals(record.name)) {
					records[i-1].phone.add(record.phone.get(i-1));	
					return true;
				}else if(records[i] == null) {
					records[i] = record;
					size++;
					return true;
				}				
			}
			return false;
		}
		
		public Record get(int i) {
			return records[i];
		}
		
		public int getSize() {
			return size;
		}
		public String find(String name) {		
			for(Record record: records) {
				if(record.name.equals(name)) {
					return (name + ": " + record.phone.get(0));
				}
			}
			return null;
		}
		
		public String findAll(String name) {
			String result = name + ":\n";
			for(Record record: records) {
				if(record.name.equals(name)) {
					for(int i = 0; i < record.phone.size(); i++) {
						result += record.phone.get(i) + "\n";
					}
					return result;	
				}
			}
			return null;
		}
	
		protected void expandArray() {
			Record[] newRecords = new Record[records.length * 2];
			System.arraycopy(records, 0, newRecords, 0, records.length);
			records = newRecords;
		}
	}
	
	
	static class Record extends PhoneDirectory{
		String name;
		ArrayList<String> phone;
				
		Record(String name, String phone, int size) {
			this.name = name;
			this.phone = new ArrayList();
			this.phone.add(phone);
		}
		public String getName() {
			return name;
		}
		
		public String getPhone(int iter) {
			return phone.get(iter);
		}
		
	}

}
