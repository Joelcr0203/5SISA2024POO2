public class pantalon extends Prendas {
    private modelo;
    public void pantalon(){


        public pantalon(String modelo){
            this.modelo = modelo;
        }
        public pantalon(int talla,String modelo){
            super(modelo,talla);
            this.modelo= modelo;
        }
   
    }
}