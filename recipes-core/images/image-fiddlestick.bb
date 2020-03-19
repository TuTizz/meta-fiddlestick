SUMMARY = "A small image for a switch filtering based on Raspberry."

IMAGE_INSTALL = "packagegroup-core-boot \
${CORE_IMAGE_EXTRA_INSTALL} \
iptables \
iproute2 \
watchdog \
"

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
#To avoid  systemd-networkd[149]: [[0;1;38;5;185m[[0;1;39m[[0;1;38;5;185mbr0: netdev could not be created: Operation not supported[[0m
# for bridge setup,  bridge module is required by systemd
IMAGE_INSTALL += " kernel-module-bridge "
IMAGE_INSTALL += " kernel-module-asix kernel-module-ax88179-178a "
