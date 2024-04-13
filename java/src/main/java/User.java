public class User {

  int rank;
  int progress;

  public User() {
    this.rank = -8;
    this.progress = 0;
  }

  public void incProgress(int rank) {
    if (rank < -8 || rank == 0 || rank > 8) {
      throw new IllegalArgumentException();
    }
    if (this.rank > 0) this.rank--;
    if (rank > 0) rank--;

    int d = rank - this.rank;
    if (d == -1) {
      this.progress++;
    } else if (d == 0) {
      this.progress += 3;
    } else if (d > 0) {
      this.progress += 10 * d * d;
    }

    this.rank += this.progress / 100;
    this.progress %= 100;
    if (this.rank >= 7) {
      this.rank = 7;
      this.progress = 0;
    }
    if (this.rank >= 0) this.rank++;
  }
}
