public class Job implements Cloneable{
  private int id, totalTime, runTime;

  public Job(int id, int totalTime, int runTime){
    this.id = id;
    this.totalTime = totalTime;
    this.runTime = runTime;
  }

  /* GETTER METHODS */
  public int getId(){
    return this.id;
  }

  public int getTotalTime(){
    return this.totalTime;
  }

  public int getRunTime(){
    return this.runTime;
  }

  public int getRemainingTime(){
    return this.totalTime - this.runTime;
  }

  /* Adds time to the runTime for the job up to totalTime */
  public void run(int time){
    if(this.runTime + time < totalTime){
      this.runTime += time;
    }
    else{
      this.runTime = totalTime;
    }
  }

  /* Returns true if job is done, false otherwise */
  public boolean isJobDone(){
    return this.totalTime == this.runTime;
  }

  /* makes a copy of the object */
  public Object clone() {
		  Object obj = null;
		  try {
				obj = super.clone();
		  } catch(CloneNotSupportedException e) {}
		  return obj;
	 }

  public String toString(){
    return " Job " + id + ": total needed = " + totalTime + "; running time = " + runTime;
}
}
