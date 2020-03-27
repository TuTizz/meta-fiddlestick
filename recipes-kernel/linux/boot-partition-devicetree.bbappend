do_install() {
    install -d -m 755 ${D}/${MENDER_BOOT_PART_MOUNT_LOCATION}/dtb

    for dtb_path in ${KERNEL_DEVICETREE}; do
	basename="${dtb_path##*/}"
        install -m 0644 ${DEPLOY_DIR_IMAGE}/$basename ${D}/${MENDER_BOOT_PART_MOUNT_LOCATION}/dtb/$dtb_base_name.$dtb_ext
    done
}
