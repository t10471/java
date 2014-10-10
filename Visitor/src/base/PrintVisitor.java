package base;

class PrintVisitor implements Visitor {

	public void visit(Wheel wheel) {
		System.out.println("Visiting " + wheel.getName() + " wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Visiting engine");
	}

	public void visit(Body body) {
		System.out.println("Visiting body");
	}

	public void visit(Vehicle vehicle) {
		System.out.println("Visiting vehicle");
	}

	public void visit(Car car) {
		System.out.println("Visiting car");
		car.getEngine().accept(this);
		car.getBody().accept(this);
		for (Wheel wheel : car.getWheels()) {
			wheel.accept(this);
		}
	}

}