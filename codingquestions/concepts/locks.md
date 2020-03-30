Spin lock:

    Spin locks can be used if amount of wait time is very less.
    If a thread is doing I/O in the synchronized section, other threads will have to wait for more time.
    Spin locks are not good here.
    But if a thread is taking minimal amount of time (say reading from cache in 1ms) and done with the work, 
    other threads can do busy wait
    spin locks.
  
 Adaptive lock:
 
    Is combination of spin lock and normal locks.
    Before java 8, if flags are enabled, initially a spin lock waits for 12 times then it will go for sleep
    Later this is removed.
Links: 
    https://www.youtube.com/watch?v=cEcNLfXEaZs
    
Test and Set, xchange: https://www.youtube.com/watch?v=yB8sm-pwvZo
