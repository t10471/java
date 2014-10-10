package base;

class DoVisitor implements Visitor {
	public void visit(Wheel wheel) {
		System.out.println("Steering my wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Starting my engine");
	}

	public void visit(Body body) {
		System.out.println("Moving my body");
	}

	public void visit(Car car) {
		System.out.println("Starting my car");
		car.getEngine().accept(this);
		car.getBody().accept(this);
		for (Wheel wheel : car.getWheels()) {
			wheel.accept(this);
		}
	}

	public void visit(Vehicle vehicle) {
		System.out.println("Starting my vehicle");
	}
}