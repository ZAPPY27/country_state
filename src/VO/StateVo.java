package VO;

public class StateVo {
private int id;
private String statename;
private CountryVo v;
public CountryVo getV() {
	return v;
}
public void setV(CountryVo v) {
	this.v = v;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatename() {
	return statename;
}
public void setStatename(String statename) {
	this.statename = statename;
}

}
