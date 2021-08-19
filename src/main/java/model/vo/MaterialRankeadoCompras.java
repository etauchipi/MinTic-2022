package model.vo;

public class MaterialRankeadoCompras {
    
    //Atributos -> Columnas de la tabla que representa la misma entidad
    private String Nombre_Material;
    private String Importado;
    private int No_Compras;

    public MaterialRankeadoCompras(){

    }

    // Getters and Setters
    public String getNombre_Material() {
        return Nombre_Material;
    }
    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }
    public String getImportado() {
        return Importado;
    }
    public void setImportado(String importado) {
        Importado = importado;
    }
    public int getNo_Compras() {
        return No_Compras;
    }
    public void setNo_Compras(int no_Compras) {
        No_Compras = no_Compras;
    }

    

}
