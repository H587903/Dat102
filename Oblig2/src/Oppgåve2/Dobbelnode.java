package Oppgåve2;

public class Dobbelnode<T> {
	private T element;
	private Dobbelnode<T> neste;
	private Dobbelnode<T> forrige;
	
	public Dobbelnode(){
		element = null;
		neste = null;
		forrige = null;
	}
	
	public Dobbelnode(T element) {
		this.element = element;
		neste = null;
		forrige = null;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public Dobbelnode<T> getNeste(){
		return neste;
	}
	
	public void setNeste(Dobbelnode<T> neste) {
		this.neste = neste;
	}
	
	public Dobbelnode<T> getForrige(){
		return forrige;
	}
	
	public void setForrige(Dobbelnode<T> forrige) {
		this.forrige = forrige;
	}
}
