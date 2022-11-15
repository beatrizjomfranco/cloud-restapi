package br.bootcamp.cloudrestapi.model;

import java.time.LocalDateTime;

public class Parking {
       
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    
    public Parking(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
}


//criação de um construtor sem parametro
public Parking() {
}



//para importar --> botão direito --> source action --> organize imports --> cria o import
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    
    private Double bill;

//gerar os getters e setter --> botão direito --> source actio --> generate getters and setters

public String getId() {
        return id;
}

public void setId(String id) {
        this.id = id;
}

public String getLicense() {
        return license;
}

public void setLicense(String license) {
        this.license = license;
}

public String getState() {
        return state;
}

public void setState(String state) {
        this.state = state;
}

public String getModel() {
        return model;
}

public void setModel(String model) {
        this.model = model;
}

public String getColor() {
        return color;
}

public void setColor(String color) {
        this.color = color;
}

public LocalDateTime getEntryDate() {
        return entryDate;
}

public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
}

public LocalDateTime getExitDate() {
        return exitDate;
}

public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
}

public Double getBill() {
        return bill;
}

public void setBill(Double bill) {
        this.bill = bill;
}






}
