FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://defconfig"

#KBUILD_DEFCONFIG_raspberrypi3-64 = "rpi3-64-fiddlestick_deconfig"

do_kernel_configme_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}
