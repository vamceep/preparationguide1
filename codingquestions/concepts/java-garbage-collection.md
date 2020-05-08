
<!DOCTYPE html>
<html lang="en">
<head><title>Types of Java Garbage Collectors - Javapapers</title>
<meta name="description" content="In this tutorial we will go through the various type of Java garbage collectors available. Garbage collection is an automatic process in Jav" /><meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="alternate" type="application/rss+xml" title="RSS 2.0"
    href="https://javapapers.com/feed/" />
<link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png?v=261118">
<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png?v=261118">
<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png?v=261118">
<link rel="manifest" href="/site.webmanifest?v=261118">
<link rel="mask-icon" href="/safari-pinned-tab.svg?v=261118" color="#5bbad5">
<link rel="shortcut icon" href="/favicon.ico?v=261118">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">
<meta property="og:title" content="Types of Java Garbage Collectors - Javapapers" />
<meta property="og:site_name"
    content="Javapapers" />
<meta property="og:description" content="In this tutorial we will go through the various type of Java garbage collectors available. Garbage collection is an automatic process in Jav" /><meta property="og:url" content="https://javapapers.com/java/types-of-java-garbage-collectors/" />
<meta property="twitter:title" content="Types of Java Garbage Collectors - Javapapers" />
<meta name="twitter:site" content="@javapapers" />
<meta property="twitter:creator" content="@javapapers" />
<meta property="og:type" content="article" />
<meta property="og:image" content="https://javapapers.com/wp-content/uploads/2014/10/Types-of-Java-Garbage-Collectors3_th.jpg" /><meta property="twitter:card" content="summary_large_image" />
<meta property="twitter:description" content="In this tutorial we will go through the various type of Java garbage collectors available. Garbage collection is an automatic process in Jav" /><meta property="twitter:image" content="https://javapapers.com/wp-content/uploads/2014/10/Types-of-Java-Garbage-Collectors3_th.jpg" /><script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-4275351-1', 'auto');
  ga('send', 'pageview');

</script>
<meta http-equiv="x-dns-prefetch-control" content="on"><link rel="dns-prefetch" href="//www.google-analytics.com"><link rel="dns-prefetch" href="//www.youtube.com"><link rel="dns-prefetch" href="//googleads.g.doubleclick.net"><link rel="dns-prefetch" href="//static.doubleclick.net"><link rel="dns-prefetch" href="//www.google.com"><link rel="dns-prefetch" href="//i.ytimg.com"><link rel="dns-prefetch" href="//yt3.ggpht.com"><link rel="dns-prefetch" href="//fonts.gstatic.com"><link rel='stylesheet' id='main-style-css'  href='https://javapapers.com/wp-content/themes/papers/papers_17191.css' type='text/css' media='all' />
<link rel="canonical" href="https://javapapers.com/java/types-of-java-garbage-collectors/" />
</head>
<body onload="prettyPrint()">
<div id="site_header">
	<div class="content">
		<a id="java-blog" href="/" title="Android &amp; Java Blog"><img
			width="142" height="29"
			src="https://javapapers.com/wp-content/themes/papers/images/javapapers.png"
			alt="Android &amp; Java Blog"></a><span class="since">Since
			2008</span>
	</div>
</div><div class="content">
        <div id="tutorial-body">
            <h1>Types of Java Garbage Collectors</h1>
            <div class='modified-on'>Last modified on June 19th, 2017 by Joe.</div>
<p>In this tutorial we will go through the various type of Java garbage collectors available. Garbage collection is an automatic process in Java which relieves the programmer of object memory allocation and de-allocation chores. This is the third part in the garbage collection tutorial series. In the previous part 2 we saw about <a href="https://javapapers.com/java/how-java-garbage-collection-works/">how garbage collection works in Java</a>, it is an interesting read and I recommend you to go through it. In the part 1 <a href="https://javapapers.com/java/java-garbage-collection-introduction/">introduction to Java garbage collection</a>, we saw about the JVM architecture, heap memory model and surrounding Java terminologies.</p>
<p><img src="https://javapapers.com/wp-content/uploads/2014/10/garbage-collection.jpg" alt="Garbage Collection" width="550" height="340" class="alignnone size-full wp-image-3792" srcset="https://javapapers.com/wp-content/uploads/2014/10/garbage-collection.jpg 550w, https://javapapers.com/wp-content/uploads/2014/10/garbage-collection-300x185.jpg 300w" sizes="(max-width: 550px) 100vw, 550px" /></p>
<p>Java has <strong>four types of garbage collectors</strong>,</p>
<ol>
<li><a href="#serial-garbage-collector">Serial Garbage Collector</a></li>
<li><a href="#parallel-garbage-collector">Parallel Garbage Collector</a></li>
<li><a href="#cms-garbage-collector">CMS Garbage Collector</a></li>
<li><a href="#g1-garbage-collector">G1 Garbage Collector</a></li>
</ol>
<p>Each of these four types has its own advantages and disadvantages. Most importantly, we the programmers can choose the type of garbage collector to be used by the JVM. We can choose them by passing the choice as JVM argument. Each of these types differ largely and can provide completely different application performance. It is critical to understand each of these types of garbage collectors and use it rightly based on the application.</p>
<p><img style="background-image: none; border-right-width: 0px; padding-left: 0px; padding-right: 0px; display: inline; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px; padding-top: 0px" title="Types-of-Java-Garbage-Collectors3_th" border="0" alt="Types-of-Java-Garbage-Collectors3_th" src="https://javapapers.com/wp-content/uploads/2014/10/Types-of-Java-Garbage-Collectors3_th_thumb.jpg" width="610" height="400" /></p>

<h2 id="serial-garbage-collector">1. Serial Garbage Collector</h2>
<p>Serial garbage collector works by holding all the application threads. It is designed for the single-threaded environments. It uses just a single thread for garbage collection. The way it works by freezing all the application threads while doing garbage collection may not be suitable for a server environment. It is best suited for simple command-line programs.</p>
<p>Turn on the <code>-XX:+UseSerialGC</code> JVM argument to use the serial garbage collector.</p>
<h2 id="parallel-garbage-collector">2. Parallel Garbage Collector</h2>
<p>Parallel garbage collector is also called as throughput collector. It is the default garbage collector of the JVM. Unlike serial garbage collector, this uses multiple threads for garbage collection. Similar to serial garbage collector this also freezes all the application threads while performing garbage collection.</p>
<h2 id="cms-garbage-collector">3. CMS Garbage Collector</h2>
<p>Concurrent Mark Sweep (CMS) garbage collector uses multiple threads to scan the heap memory to mark instances for eviction and then sweep the marked instances. CMS garbage collector holds all the application threads in the following two scenarios only,</p>
<ol>
<li>while marking the referenced objects in the tenured generation space. </li>
<li>if there is a change in heap memory in parallel while doing the garbage collection. </li>
</ol>
<p>In comparison with parallel garbage collector, CMS collector uses more CPU to ensure better application throughput. If we can allocate more CPU for better performance then CMS garbage collector is the preferred choice over the parallel collector.</p>
<p>Turn on the <code>XX:+USeParNewGC</code> JVM argument to use the CMS garbage collector.</p>
<h2 id="g1-garbage-collector">4. G1 Garbage Collector</h2>
<p>G1 garbage collector is used for large heap memory areas. It separates the heap memory into regions and does collection within them in parallel. G1 also does compacts the free heap space on the go just after reclaiming the memory. But CMS garbage collector compacts the memory on stop the world (STW) situations. G1 collector prioritizes the region based on most garbage first. </p>
<p>Turn on the <code>–XX:+UseG1GC</code> JVM argument to use the G1 garbage collector.</p>
<h3>Java 8 Improvement</h3>
<p>Turn on the <code>-XX:+UseStringDeduplication</code> JVM argument while using G1 garbage collector. This optimizes the heap memory by removing duplicate String values to a single char[] array. This option is introduced in <a href="https://javapapers.com/java/java-8-features/" title="Java 8 Features">Java 8</a> u 20.</p>
<p>Given all the above four types of Java garbage collectors, which one to use depends on the application scenario, hardware available and the throughput requirements.</p>
<h2>Garbage Collection JVM Options</h2>
<p>Following are the key JVM options that are related to Java garbage collection.</p>
<h3>Type of Garbage Collector to run</h3>
<table class="tutorial-table">
<tbody>
<tr>
<th>        Option</th>
<th>Description</th>
</tr>
<tr>
<td>-XX:+UseSerialGC</td>
<td>Serial Garbage Collector</td>
</tr>
<tr>
<td>-XX:+UseParallelGC</td>
<td>Parallel Garbage Collector</td>
</tr>
<tr>
<td>-XX:+UseConcMarkSweepGC</td>
<td>CMS Garbage Collector</td>
</tr>
<tr>
<td>-XX:ParallelCMSThreads=<n></td>
<td>CMS Collector &#8211; number of threads to use</td>
</tr>
<tr>
<td>-XX:+UseG1GC</td>
<td>G1 Gargbage Collector</td>
</tr>
</tbody>
</table>
<h3>GC Optimization Options</h3>
<table class="tutorial-table">
<tbody>
<tr>
<th>Option</th>
<th>Description</th>
</tr>
<tr>
<td>-Xms</td>
<td>Initial heap memory size</td>
</tr>
<tr>
<td>-Xmx</td>
<td>Maximum heap memory size</td>
</tr>
<tr>
<td>-Xmn</td>
<td>Size of Young Generation</td>
</tr>
<tr>
<td>-XX:PermSize</td>
<td>Initial Permanent Generation size</td>
</tr>
<tr>
<td>-XX:MaxPermSize</td>
<td>Maximum Permanent Generation size</td>
</tr>
</tbody>
</table>
<h3>Example Usage of JVM GC Options</h3>
<pre class="prettyprint lang-java">java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseSerialGC -jar java-application.jar</pre>
<p>In the next part of this Java garbage collection tutorial series, we will see about how to monitor and analyze the garbage collection with an example Java application.</p>
            <div class="share">
                <ul>
                    <li><a
                        href="https://www.facebook.com/sharer/sharer.php?u=https://javapapers.com/java/types-of-java-garbage-collectors/"><img
                            src="https://javapapers.com/wp-content/themes/papers/images/facebook-social.png"
                            title="Share on Facebook" /></a></li>
                    <li><a
                        href="https://twitter.com/intent/tweet?original_referer=https://javapapers.com&amp;source=tweetbutton&amp;text=Types of Java Garbage Collectors;url=https://javapapers.com/java/types-of-java-garbage-collectors/&amp;via=javapapers"><img
                            src="https://javapapers.com/wp-content/themes/papers/images/twitter-social.png"
                            title="Share on Twitter" /></a></li>
                    <li><a
                        href="https://www.linkedin.com/shareArticle?mini=true&url=https://javapapers.com/java/types-of-java-garbage-collectors/&media=Types of Java Garbage Collectors"><img
                            src="https://javapapers.com/wp-content/themes/papers/images/linkedin-social.png"
                            title="Share on Linkedin" /></a></li>
                </ul>
            </div>



    <div class="related-articles">
                <h2>Popular Articles</h2>
                <ul class="related-articles-list">
                        <li><a href="https://javapapers.com/java/how-java-garbage-collection-works/">How Java Garbage Collection Works?</a></li>
                        <li><a href="https://javapapers.com/java/java-garbage-collection-introduction/">Java Garbage Collection Introduction</a></li>
                        <li><a href="https://javapapers.com/java/java-garbage-collection-monitoring-and-analysis/">Java Garbage Collection Monitoring and Analysis</a></li>
                    </ul>
            </div>
<div id="comments" class="comments-area">
        <h2 class="comments-title">Comments on "Types of Java Garbage Collectors"</h2>
    <ol class="commentlist">		<li class="pingback even thread-even depth-1" id="comment-148724">
				<div id="div-comment-148724" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn"><a href='https://javapapers.com/java/java-garbage-collection-introduction/' rel='external nofollow' class='url'>Java Garbage Collection Introduction</a></cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-148724">
			12/10/2014 at 11:20 pm</a>		</div>

		<p>[&#8230;] Types of Java Garbage Collectors [&#8230;]</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="pingback odd alt thread-odd thread-alt depth-1" id="comment-148725">
				<div id="div-comment-148725" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn"><a href='https://javapapers.com/java/how-java-garbage-collection-works/' rel='external nofollow' class='url'>How Java Garbage Collection Works?</a></cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-148725">
			12/10/2014 at 11:21 pm</a>		</div>

		<p>[&#8230;] is the third part of the garbage collection tutorial series and we will see about the different types of Java garbage collectors [&#8230;]</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-148805">
				<div id="div-comment-148805" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Dharmesh</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-148805">
			13/10/2014 at 10:56 am</a>		</div>

		<p>Good One</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment odd alt thread-odd thread-alt depth-1" id="comment-148858">
				<div id="div-comment-148858" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Tom Henricksen</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-148858">
			13/10/2014 at 6:02 pm</a>		</div>

		<p>This is a good summary of Java garbage collection, every Java developer should have a basic understanding of this.  It comes up time and again and the GC Optimizations are important to know when setting up an environment.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-149043">
				<div id="div-comment-149043" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Niraj Kumar</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-149043">
			14/10/2014 at 4:59 pm</a>		</div>

		<p>Hi Joe, </p>
<p>I was looking for detailed information on Java GC starting from basic concepts to how many types of GC are there and how they work. </p>
<p>Can you please also add some details on Permanent Generation or PermGen. Usually, this is the hot topic in interviews :-).</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment byuser comment-author-admin bypostauthor odd alt thread-odd thread-alt depth-1" id="comment-149061">
				<div id="div-comment-149061" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn"><a href='https://javapapers.com' rel='external nofollow' class='url'>Joe</a></cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-149061">
			14/10/2014 at 7:21 pm</a>		</div>

		<p>PermGen is the memory space where the program meta data is stored. Information like the classes and methods.</p>
<p>Do not worry about it much now. From Java SE 8, PermGen space is removed.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-152817">
				<div id="div-comment-152817" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Prateep Kumar Thadi</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-152817">
			16/11/2014 at 8:16 pm</a>		</div>

		<p>Thanks Joe, superbly explained.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment odd alt thread-odd thread-alt depth-1" id="comment-157172">
				<div id="div-comment-157172" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Imran</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-157172">
			07/01/2015 at 11:42 pm</a>		</div>

		<p>Excellent tutorial on GC concept.. Nicely explained with simple programs.Gr8 Job. Thanks</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-157408">
				<div id="div-comment-157408" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Hamid</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-157408">
			28/01/2015 at 4:26 pm</a>		</div>

		<p>Hi man, I love your articles. The best style ever.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment odd alt thread-odd thread-alt depth-1" id="comment-158261">
				<div id="div-comment-158261" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Kishor</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158261">
			25/07/2015 at 2:55 pm</a>		</div>

		<p>Best work Joe, It is really helpful to me. Keep it up. God bless U.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-158445">
				<div id="div-comment-158445" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Pooja</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158445">
			08/08/2015 at 2:33 am</a>		</div>

		<p>Hi,</p>
<p>Awesome explaination.</p>
<p>I have a simple question.<br />
What is this unit used in jvm arguments here? like 20m; what is this &#8216;m&#8217; here?</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment odd alt thread-odd thread-alt depth-1" id="comment-158465">
				<div id="div-comment-158465" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">anees</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158465">
			10/08/2015 at 4:17 pm</a>		</div>

		<p>@ Pooja: m is MB(MegaByte)</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-158525">
				<div id="div-comment-158525" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Sri</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158525">
			16/08/2015 at 1:18 am</a>		</div>

		<p>Nice summary!</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment odd alt thread-odd thread-alt depth-1" id="comment-158580">
				<div id="div-comment-158580" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">deepak patwal</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158580">
			19/08/2015 at 5:16 pm</a>		</div>

		<p>Can you provide these materials in pdf or docx format.</p>

		
				</div>
		</li><!-- #comment-## -->
		<li class="comment even thread-even depth-1" id="comment-158764">
				<div id="div-comment-158764" class="comment-body">
				<div class="comment-author vcard">
						<cite class="fn">Bala J</cite> <span class="says">says:</span>		</div>
		
		<div class="comment-meta commentmetadata"><a href="https://javapapers.com/java/types-of-java-garbage-collectors/#comment-158764">
			30/08/2015 at 5:55 am</a>		</div>

		<p>Hi Joe,</p>
<p>Very Nice Articles, simple and easy for learning. It would be great if you can write article about JVM -XX switches. There are so many  and the purpose and when it would be optimal to use with examples. May be recommended switches/options for productions and how to eliminate duplicate switches.</p>

		
				</div>
		</li><!-- #comment-## -->
</ol>
<p class="no-comments">Comments are closed for "Types of Java Garbage Collectors".</p></div></div>
</div>
<div id="footer">
	<div class="content">
		<div class="subscribe-section">
			<form action="https://feedburner.google.com/fb/a/mailverify"
				method="post" target="popupwindow"
				onsubmit="window.open('https://feedburner.google.com/fb/a/mailverify?uri=javapapers/java-interview-questions',
             'popupwindow', 'scrollbars=yes,width=550,height=520');return true">
				<div>
					<label for="feedb-email-inp">Subscribe:</label>
				</div>
				<input id="feedb-email-inp" placeholder="Enter your email here"
					type="text" class="feedb-email" name="email"><input type="hidden"
					value="javapapers/java-interview-questions" name="uri" /><input
					type="hidden" name="loc" value="en_US" /><input type="submit"
					value="Subscribe" class="subscribe" />
			</form>
			<div class="follow">
				<a class="facebook" href="https://www.facebook.com/javapapers"
					rel="nofollow noopener"
					title="Javapapers Facebook Page" target="_blank">Javapapers Facebook Page</a>
			</div>
		</div>
		<p class="copyright">
			&copy; 2008 - 2019 <a href="/"
				title="Android &amp; Java Blog">Javapapers</a>
		</p>
	</div>
</div><script src="https://javapapers.com/wp-content/themes/papers/prettify.js"></script>
</body>
</html>
