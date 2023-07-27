package com.jitesh.immutable.sealed;

public abstract sealed class SpecialAbstractClass permits SealedKid, SpecialAbstractClass.Kid,NonSealedKid,FinalKid  {
     final class Kid extends  SpecialAbstractClass{

     }
}
