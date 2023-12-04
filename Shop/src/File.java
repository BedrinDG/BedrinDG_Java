import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class File {
    public String showAllProducts(){
        StringBuilder result = new StringBuilder();
        JSONArray depart = (JSONArray) parseJSON().get("department");
        for (Object item:depart){
            result.append("Department: ")
                    .append((String) ((JSONObject) item).get("name"))
                    .append("\n\t");
            JSONArray produc = (JSONArray) ((JSONObject)item).get("product");
            for (Object item_1:produc){
                result.append((String) ((JSONObject) item_1).get("name"))
                        .append(" Цена: ")
                        .append((String) ((JSONObject) item_1).get("price"))
                        .append("\n\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
    public String showProductInTheDepartment(String name){
        StringBuilder result = new StringBuilder();
        JSONArray depart = (JSONArray) parseJSON().get("department");
        for (Object item : depart){
            if (name.equals(((JSONObject) item).get("name"))) {
                result.append("Department: ")
                        .append((String) ((JSONObject) item).get("name"))
                        .append("\n\t");
                JSONArray produc = (JSONArray) ((JSONObject) item).get("product");
                for (Object item_1 : produc) {
                    result.append((String) ((JSONObject) item_1).get("name"))
                            .append(" Цена: ")
                            .append((String) ((JSONObject) item_1).get("price"))
                            .append("\n\t");
                }
                result.append("\n");
            }
        }
        return result.toString();
    }
    public String showEmptyDepartment(){
        StringBuilder result = new StringBuilder();
        JSONArray depart = (JSONArray) parseJSON().get("department");
        for (Object item:depart) {
            JSONArray produc = (JSONArray) ((JSONObject) item).get("product");
            if(produc.isEmpty()) {
                result.append("Empty Department: ")
                        .append((String) ((JSONObject) item).get("name"))
                        .append("\n");
            }
        }
        return result.toString();
    }
    public String addProduct(String name, String department, String price){
        JSONObject root = parseJSON();
        JSONArray depart = (JSONArray) root.get("department");
        JSONObject newProduct = new JSONObject();
        for (Object item : depart) {
            if (department.equals(((JSONObject) item).get("name"))) {
                JSONArray produc = (JSONArray) ((JSONObject) item).get("product");
                newProduct.put("name", name);
                newProduct.put("price", price);
                produc.add(newProduct);
                writeJSON(root);
                return "Product add";
            }
        }
        return "Department not found";
    }
    public String addDepartment(String department, String openingHours){
        JSONObject root = parseJSON();
        JSONArray depart = (JSONArray) root.get("department");
        if(checkTheDepartmentForDuplicates(depart, department)){
            return "A department with the same name already exists";
        }
        JSONObject newDepart = new JSONObject();
        newDepart.put("name", department);
        newDepart.put("opening hours", openingHours);
        newDepart.put("product", new JSONArray());
        depart.add(newDepart);
        writeJSON(root);
        return "Department add";
    }
    public String deleteProduct(String name, String department){
        int counterDepartment = 0;
        JSONObject root = parseJSON();
        JSONArray depart = (JSONArray) root.get("department");
        for(Object departItem : depart){
            if (department.equals(((JSONObject) departItem).get("name"))){
                int counterProduct = 0;
                JSONArray product = (JSONArray) ((JSONObject) depart
                        .get(counterDepartment))
                        .get("product");
                for (Object productItem : product){
                    if(name.equals(((JSONObject) productItem)
                            .get("name"))){
                        product.remove(counterProduct);
                        writeJSON(root);
                        return "Product removed";
                    }
                    counterProduct++;
                }
                return "Product not found";
            }
            counterDepartment++;
        }
        return "Department not found";
    }
    public String deleteDepartment(String department){
        int counterDepartment = 0;
        JSONObject root = parseJSON();
        JSONArray depart = (JSONArray) root.get("department");
        for(Object departItem : depart){
            if (department.equals(((JSONObject) departItem).get("name"))){
                depart.remove(counterDepartment);
                writeJSON(root);
                return "Department removed";
            }
            counterDepartment++;
        }
        return "Department not found";
    }
    private boolean checkTheDepartmentForDuplicates(JSONArray depart, String nameDepart){
        for (Object dep : depart){
            if (nameDepart.equals(((JSONObject) dep).get("name"))){
                return true;
            }
        }
        return false;
    }
    private JSONObject parseJSON(){
        try(FileReader reader = new FileReader("Shop.json")){
            JSONParser parser = new JSONParser();
            return  (JSONObject) parser.parse(reader);
        }catch (Exception e){
            System.out.println("Parsing error: " + e);
            return new JSONObject();
        }
    }
    private void writeJSON(JSONObject root){
        try(FileWriter writer = new FileWriter("Shop.json")){
            writer.write(root.toJSONString());
            writer.flush();
        }catch (Exception e){
            System.out.println("Write error: " + e);
        }
    }
}