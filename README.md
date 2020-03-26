# meta-fiddlestick

Filter switch based on Raspberry

This README file contains information on the contents of the meta-fiddlestick layer.

Please see the corresponding sections below for details.

Dependencies
============
Build Configuration:

BB_VERSION           = "1.44.0"

BUILD_SYS            = "x86_64-linux"

NATIVELSBSTRING      = "universal"

TARGET_SYS           = "aarch64-poky-linux"

MACHINE              = "raspberrypi3-64"

DISTRO               = "poky-fiddlestick"

DISTRO_VERSION       = "1.0"

TUNE_FEATURES        = "aarch64 cortexa53 crc"

TARGET_FPU           = ""

meta                 

meta-poky            

meta-yocto-bsp       = "zeus:f9ef210967ab34168d4a24930987dc0731baf56f"

meta-oe              

meta-python          

meta-networking      = "zeus:bb65c27a772723dfe2c15b5e1b27bcc1a1ed884c"

meta-raspberrypi     = "zeus:d17588fe8673b794b589335a753f4c1c90e12f88"

meta-fiddlestick     = "master:1169ae4718b5bed38af2de04a87c7c94dcae0450"

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

IV. What have been done so far
==============================
ssh : to allow your computer to access your device over ssh, AUTHORIZED_KEYS variable have to be set to a valid value in your local.conf. AUTHORIZED_KEYS="/home/myid/myvar/mypublickeys"

nftables : to customize the nftables rules that will be applied, you have to create your own rules and the NFTABLES_CONF_FILE variable have to be set to a valid value in your local.conf. NFTABLES_CONF_FILE="/home/myid/myvar/mynftablesconf"

rootpasswd : you may want to init your root's passwd into your local.conf. ROOT_PASSWORD="myrootpasswd", if not it will be empty.

watchdog : watchdog is activated forkbomb if you want to test it : root@raspberrypi3-64:~# a(){ a|a& };a

@mac br0 = @mac Raspberry

snmp : is now available, basic OID exposed