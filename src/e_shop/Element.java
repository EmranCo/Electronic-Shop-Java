
package e_shop;


public class Element {
    
 protected int number;
 protected int price;
 protected String name;
 protected String color; 
 protected int quantity;
 protected Element next;

 
 public Element (int num, int pri, String nam, String col, int q) {
  number = num; 
  price = pri;
  name=nam; 
  color=col;
 quantity=q; 
 next = null;
 }

public int getNumber(){
    return number;
}


public int getPrice () {
    return price;
} 

public String getName (){ 
    return name;
}

 public String getColor(){ 
     return color;
 } 
 public int getQuantity () { 
    return quantity; 
}
 public Element getNext () { 
     return next;
 } 

 public void setNumber (int n) { 
     number = n;
 } 
public void setPrice (int p){
     price = p; 
} 
public void setName (String n) { 
    name = n;
} 
public void setColor (String c){ 
    color = c;
} 
public void setQuantity (int q) {
    quantity = q;
} 
 public void setNext (Element e){
     next = e;
 }

  public String  display () {
      return getNumber()+"\t"+getPrice()+"\t"+getName()+"\t"+getColor()+"\t"+getQuantity();
   //System.out.print(get);
      //  System.out.print(getNumber()+"\t"+getPrice()+"\t"+getName()+"\t"+getColor()+"\t"+getQuantity(); 
} }//end class ELement 




    

