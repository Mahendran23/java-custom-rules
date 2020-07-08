/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidTooManyParametersForMethodCheck {

	
	public void methodTest(int input1, int input2,int input3,int input4,int input5) { // Noncompliant {{Too Many Parameters}}
		System.out.println(input1+input2+input3+input4+input5);
	}
	public void methodTest(int input1, int input2,int input3)
	{
		System.out.println(input1+input2+input3);
	}

}
