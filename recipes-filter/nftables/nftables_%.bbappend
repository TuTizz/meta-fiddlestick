FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

NFTABLES_CONF_FILE ?= ""

inherit systemd

SRC_URI += "file://nftables.service \
            "
do_install_append() {
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/nftables.service ${D}${systemd_system_unitdir}

	sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}${systemd_system_unitdir}/nftables.service
}

SYSTEMD_SERVICE_${PN} = "nftables.service"



