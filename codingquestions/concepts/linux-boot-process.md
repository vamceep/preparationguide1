https://www.youtube.com/watch?v=ZtVpz5VWjAs

BIOS -> MBR -> GRUP -> KERNEL -> INIT (PROCESS) -> RUNLEVEL

---------------------------------------------
Linux Boot process( fedora):

1. After power on
	- POST  - Power On Self Test is done:
		- Each hardware tests itself if it can boot / load
    
2. If above is success, BIOS (Basic Input Output) is loaded
 -- performs integirity checks, seraches and loaed boot loard program.
 -- ***BIOS load and executes MBR found from the hdd.
	- I/O 
	- ram 
	- such order of hard ware (floppy, cd, hd1, hd2, network etc..)
3. After that fist sector of Hard disk is MBR is read which is of 512 bytes

4. MBR (512 bytes) 
	-> 446 bytes of BootLoader 
  -> 64 bytes of Partition Table 
  -> 2bytes of Magic Number
--** MBR loads and executes GRUB boot loader

5. It gets GRUB (GRand Unified BootLoader)

6. From GRUB, it gets kernel Image
  -- GRUB allows to choose one of multiple kernel boot images (As a table of options)
    - Defalut kernel image is loaded if no option is given (Which is configurable)
	-- config file /boot/grub/grub.conf
  -- loads and executes init rd(initial ram disk)
    -- this is used as termporarily used as disk until kernel loads actual file system
	-- GRUB loads kernel.
7. KERNEL mounts root file system
  -- as specified in/boot/grub/grub.conf
  -- kernel executes /sbin/init located under root file system.
8. init spawns all other processes.
	- process id of init is 1.
(In short in 7 + 8, kernel load files sytem and runs init for for loading of processes)

9. init decides runlevel
    -- 0 halt
    -- 1 single user level
    -- 2 multi user level without NFS
    -- 3 multi user level or full multi user
    -- 4 UNUSED
    -- 5 X11
    -- 6 reboot
    
Notes:
** PID of scheduler is 0
00 PID of init is 0

Useful images:
<img src="https://static.thegeekstuff.com/wp-content/uploads/2011/02/linux-boot-process.png" width="300">
<img src="https://opensource.com/sites/default/files/u128651/linuxboot_3.png">
