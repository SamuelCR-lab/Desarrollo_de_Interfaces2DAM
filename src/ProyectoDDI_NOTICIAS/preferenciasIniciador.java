package ProyectoDDI_NOTICIAS;

public class preferenciasIniciador {
	 	public int Id;
	    public int Marca = 0;
	    public int AS = 0;
	    public int OKdiario = 0;
	    public int eleconomista = 0;
	    public int elespanolECO = 0;
	    public int elmundoECO = 0;
	    public int elespanolN = 0;
	    public int elmundoN = 0;
	    public int okdiarioN = 0;
	    public int elespanolI = 0;
	    public int elmundoI = 0;
	    public int okdiarioI = 0;
	    public int xataka = 0;
	    public int applesfera = 0;
	    public int mundoxiaomi = 0;
	    public int vandal = 0;
	    public int directoalpaladar = 0;
	    public int sensacine = 0;

	    // CONSTRUCTOR VACÍO (Necesario para inicializarlo en la pantalla de preferencias)
	    public preferenciasIniciador() {
	        // Inicializa todo a 0 por defecto
	    }

	    // Constructor completo (lo mantenemos por si lo usas en otro lado)
	    public preferenciasIniciador(int Id, int marca, int aS, int oKdiario, int eleconomista, int elespanolECO, int elmundoECO,
	            int elespanolN, int elmundoN, int okdiarioN, int elespanolI, int elmundoI, int okdiarioI, int xataka,
	            int applesfera, int mundoxiaomi, int vandal, int directoalpaladar, int sensacine) {
	        super();
	        this.Id = Id;
	        this.Marca = marca;
	        this.AS = aS;
	        this.OKdiario = oKdiario;
	        this.eleconomista = eleconomista;
	        this.elespanolECO = elespanolECO;
	        this.elmundoECO = elmundoECO;
	        this.elespanolN = elespanolN;
	        this.elmundoN = elmundoN;
	        this.okdiarioN = okdiarioN;
	        this.elespanolI = elespanolI;
	        this.elmundoI = elmundoI;
	        this.okdiarioI = okdiarioI;
	        this.xataka = xataka;
	        this.applesfera = applesfera;
	        this.mundoxiaomi = mundoxiaomi;
	        this.vandal = vandal;
	        this.directoalpaladar = directoalpaladar;
	        this.sensacine = sensacine;
	    }
	
	
	  
}
