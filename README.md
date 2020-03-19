# meta-fiddlestick
Filter switch based on Raspberry

This README file contains information on the contents of the meta-fiddlestick layer.

Please see the corresponding sections below for details.

Dependencies
============

BB_VERSION           = "1.44.0"                                                                                   
BUILD_SYS            = "x86_64-linux"                                                                             
NATIVELSBSTRING      = "universal"                                                                                
TARGET_SYS           = "aarch64-poky-linux"                                                                       
MACHINE              = "raspberrypi3-64"                                                                          
DISTRO               = "poky"                                                                                     
DISTRO_VERSION       = "3.0.2"                                                                                    
TUNE_FEATURES        = "aarch64 cortexa53 crc"                                                                    
TARGET_FPU           = ""                                                                                         
meta                                                                                                              
meta-poky                                                                                                         
meta-yocto-bsp       = "zeus:04d71b42e7323087b945e9c507337c1cfb54f48b"                                            
meta-raspberrypi     = "master:ac5e346167717021d232eb51018a7ddf5efa8504"                                          
meta-fiddlestick     = "zeus:04d71b42e7323087b945e9c507337c1cfb54f48b" 


Patches
=======

Please submit any patches against the meta-fiddlestick layer to the xxxx mailing list (xxxx@zzzz.org)
and cc: the maintainer:

Maintainer: XXX YYYYYY <xxx.yyyyyy@zzzzz.com>

Table of Contents
=================

  I. Adding the meta-fiddlestick layer to your build
 II. Misc
 III. Run

I. Adding the meta-fiddlestick layer to your build
=================================================

Run 'bitbake-layers add-layer meta-fiddlestick'

II. Misc
========

source oe-init-build-env
Copy meta-fiddlestick/conf/bblayers.conf build/conf/
Copy meta-fiddlestick/conf/local.conf build/conf/


III. Run
========
bitbake image-fiddlestick



--- replace with specific information about the meta-fiddlestick layer ---
