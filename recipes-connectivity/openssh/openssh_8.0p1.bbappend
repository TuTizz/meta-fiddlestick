FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://authorized_keys \
            file://sshd_config \
            "

FILES_${PN} += " \
    ${ROOT_HOME}/.ssh \
    ${ROOT_HOME}/.ssh/authorized_keys \
"

do_install_append() {
    install -d ${D}${ROOT_HOME}/.ssh
    install -m 0644 ${WORKDIR}/authorized_keys ${D}${ROOT_HOME}/.ssh
}
