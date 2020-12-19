package com.example.prematurebabyandroid;


public interface CharacterCallback  {
//    Patient globalPatient = new Character();

//    public void setGlobalPatientID(int id){
//        globalPatient.setPatient_id(id);
//    }

//    public int getGlobalPatientID(){
//        return globalPatient.getPatient_id();
//    }
    void onSuccess(Character character);

    void  onError(Throwable throwable);

}
