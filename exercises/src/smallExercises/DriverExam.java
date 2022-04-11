package smallExercises;

public class DriverExam {

	public static void executeExercise(IExercise exercise) throws Exception {

		try {
			exercise.start();
			exercise.execute();
		} catch (Exception e) {
			exercise.markNegativePoints();
		} finally {
			exercise.end();
		}
	}

	public static void main(String[] args) throws Exception {

		DriverExam.executeExercise(new Exercise());

	}
}

class Exercise implements IExercise {
	public void start() {
		System.out.println("Start");
//		if (1 == 1) // I put this 'if' here so that the code compiles
//		{
//			throw new RuntimeException("This is thrown intentionally");
//		}
	}

	public void execute() {
		System.out.println("Execute");
	}

	public void markNegativePoints() {
		System.out.println("MarkNegativePoiints");
	}

	public void end() {
		System.out.println("End");

	}
}

interface IExercise {
	void start() throws Exception;

	void execute();

	void markNegativePoints();

	void end();
}
