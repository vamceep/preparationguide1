package preparation.locking;

public class ReaderWriterLocking {
    /**
     * details to capture reader writer locks details
     * https://github.com/angrave/SystemProgramming/wiki/Synchronization%2C-Part-7%3A-The-Reader-Writer-Problem
     *
     * https://stackoverflow.com/questions/19172541/procs-fork-and-mutexes
     */
    /*
    int writers ; // writers count
    int reading; // intimation of current reading process
    int writing; // intimation of current writing process
    reader() {
        lock(&m)                        // acquire lock
        while(writers) {                // if there are writers wait to finish
            cond_wait(&cv, &m)
        }
        reading++;                      // increment reading count
        unlock(&m);                     // give away lock since writer cann't do anything but other reader can do
                                        // parallel reads
        // perform task

        lock(&m)                        // acquire lock again
        reading--;                      // decrement reading (current thread)
        cond_broadcast(&cv);            // inform other sleeping threads who are waiting for lock
        unlock(&m)                      // unlock mutex
     }

     writer() {
        lock(&m)                        // acquire lock
        writers++;                      // indicate a writer
        while(reading || writing) {     // wait for all readers or any existing writer to finish
            cond_wait(&cv, &m)
        }
        writing++;                      // increment writing task
        unlock(&m)                      // unlock

        // perform task

        lock(&m)                        // acquire lock to release
        writing--;                      // decrement writing task
        writers--;                      // release writer
        cond_broadcast(&cv)             // inform everyone
        unlock(&m)                      // unlock
     */

}
