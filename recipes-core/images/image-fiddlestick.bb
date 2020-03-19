SUMMARY = "A small image for a switch filtering based on Raspberry."

IMAGE_INSTALL = "packagegroup-core-boot \
${CORE_IMAGE_EXTRA_INSTALL} \
iptables \
iproute2 \
watchdog \
ssh \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
