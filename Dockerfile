
# =======================================
# Dockerfile for SpringDock Application
# =======================================

FROM baseImage

WORKDIR /the/workdir/path

COPY source dest

EXPOSE port

ENTRYPOINT [ "executable" ]