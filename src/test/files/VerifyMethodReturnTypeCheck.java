/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidTooManyParametersForMethodCheck {

	
	public int methodTest(int input1) { // Noncompliant {{Method Return Typs is same as first Parameter}}
		return input1;
	}
	

}